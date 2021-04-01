package com.intuit.dsl.expression.runtime.evaluator.function;

import static com.intuit.dsl.expression.runtime.util.EvaluatorUtils.joinKeys;

import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.MapFunc;
import com.intuit.dsl.expression.MapStatement;
import com.intuit.dsl.expression.Range;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import com.intuit.dsl.expression.runtime.model.RuntimeOptions;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.emf.common.util.EList;

@Slf4j
public class MapFuncEvaluator implements Evaluator<MapFunc> {

  ExpressionEvaluator expressionEvaluator;

  public MapFuncEvaluator(ExpressionEvaluator expressionEvaluator) {
    this.expressionEvaluator = expressionEvaluator;
  }

  @Override
  public DataValue evaluate(final MapFunc map) {
    DataValue value = expressionEvaluator.doSwitch(map.getExp());
    try {
      if (Objects.nonNull(map.getReturnexp())) {
        return mapReturnExp(value, map.getReturnexp(), map.getRange(), expressionEvaluator);
      } else {
        return map(value, map.getStatement(), map.getAliasKey(), map.getRange(), expressionEvaluator);
      }
    } catch (Exception e) {
      log.debug("Exception caught in map function " + e.getMessage());
      return value;
    }
  }

  //Todo: Code cleanup
  private static DataValue mapReturnExp(DataValue value, Expression returnExp, Range range,
      ExpressionEvaluator expressionEvaluator) {
    RuntimeOptions pragmas = expressionEvaluator.getRuntimeOptions();
    if (value.getType() == DataValue.Type.ARRAY) {
      long low = EvaluatorUtils.getLowRangeValue(expressionEvaluator, range);
      long high = EvaluatorUtils.getHighRangeValue(expressionEvaluator, range, value);
      JsonModel resultNode = JsonModel.arrayNode(pragmas.getNumberPragma());
      Iterator<DataModel> iter = new JsonModel(value, pragmas.getNumberPragma()).toList().iterator();
      long index = 0;
      while (iter.hasNext()) {
        DataModel local = iter.next();
        if (index >= low && index <= high) { // Check for range
          // local evaluator
          ExpressionEvaluator expressionVisitor = expressionEvaluator.transform(builder -> {
            builder.withParentVisitor(expressionEvaluator);
            builder.withInputs(local.fields());
          });
          DataValue element = expressionVisitor.doSwitch(returnExp);
          resultNode.add(new JsonModel(element, pragmas.getNumberPragma()));
        }
        index++;
      }
      return resultNode.getValue();
    }
    return value;
  }

  private static DataValue map(DataValue value, EList<MapStatement> statements, String aliasKey, Range range,
      ExpressionEvaluator expressionEvaluator) {
    RuntimeOptions pragmas = expressionEvaluator.getRuntimeOptions();
    if (value.getType() == DataValue.Type.ARRAY) {
      long low = EvaluatorUtils.getLowRangeValue(expressionEvaluator, range);
      long high = EvaluatorUtils.getHighRangeValue(expressionEvaluator, range, value);
      JsonModel resultNode = JsonModel.arrayNode(pragmas.getNumberPragma());
      Iterator<DataModel> iter = new JsonModel(value, pragmas.getNumberPragma()).toList().iterator();
      long index = 0;
      while (iter.hasNext()) {
        DataModel local = iter.next();
        // Check for range
        if (index >= low && index <= high) {
          // construct the map for local expression evaluation
          JsonModel obj = JsonModel.objectNode(pragmas.getNumberPragma());
          for (MapStatement statement : statements) {
            Map<String, DataModel> map = (StringUtils.isNotEmpty(aliasKey)) ?
                Collections.singletonMap(aliasKey, local) : local.fields();
            // Using local evaluator.
            ExpressionEvaluator expressionVisitor = expressionEvaluator.transform(builder -> {
              builder.withParentVisitor(expressionEvaluator);
              builder.withInputs(map);
            });
            DataValue n = expressionVisitor.doSwitch(statement);
            obj.replace(joinKeys(statement.getResultKey()), new JsonModel(n, pragmas.getNumberPragma()));
          }
          resultNode.add(obj);
        }
        index++;
      }
      return resultNode.getValue();
    } else if (value.getType() == DataValue.Type.OBJECT) {

      JsonModel resultNode = JsonModel.objectNode(pragmas.getNumberPragma());
      JsonModel valueNode = new JsonModel(value, pragmas.getNumberPragma());
      for (MapStatement statement : statements) {
        ExpressionEvaluator expressionVisitor = expressionEvaluator.transform(builder -> {
          builder.withParentVisitor(expressionEvaluator);
          builder.withInputs(valueNode.fields());
        });
        DataValue n = expressionVisitor.doSwitch(statement);
        resultNode.replace(joinKeys(statement.getResultKey()), new JsonModel(n, pragmas.getNumberPragma()));
      }
      return resultNode.getValue();
    }
    return value;
  }


}
