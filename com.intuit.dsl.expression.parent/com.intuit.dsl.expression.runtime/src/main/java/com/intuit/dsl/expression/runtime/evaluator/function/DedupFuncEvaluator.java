package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.DedupFunc;
import com.intuit.dsl.expression.SchemaVariable;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DedupFuncEvaluator implements Evaluator<DedupFunc> {

  ExpressionEvaluator expressionEvaluator;

  public DedupFuncEvaluator(ExpressionEvaluator visitor) {
    this.expressionEvaluator = visitor;
  }

  @Override
  public DataValue evaluate(final DedupFunc dedupFunc) {

    DataValue dataValue = expressionEvaluator.doSwitch(dedupFunc.getExp());
    try {
      if (dataValue.getType() == DataValue.Type.ARRAY) {
        return dedup(dataValue, dedupFunc.getKey(), expressionEvaluator);
      }
    } catch (Exception e) {
      log.debug("Exception caught in dedup function " + e.getMessage());
    }
    return dataValue;
  }

  private static DataValue dedup(DataValue value, SchemaVariable key, ExpressionEvaluator expressionEvaluator) {
    final boolean numberPragma = expressionEvaluator.getRuntimeOptions().getNumberPragma();

    List<DataModel> newList = new JsonModel(value, numberPragma).toList();
    DataModel dedupList = JsonModel.arrayNode(numberPragma);
    Set<DataValue> set = new HashSet();

    for (DataModel elem : newList) {
      DataValue k = (Objects.isNull(key))
          ? elem.getValue()
          : expressionEvaluator.transform(builder -> {
            builder.withParentVisitor(expressionEvaluator);
            builder.withInputs(elem.fields());
          }).doSwitch(key);
      if (set.add(k)) {
        dedupList.add(elem);
      }
    }
    return dedupList.getValue();

  }

}
