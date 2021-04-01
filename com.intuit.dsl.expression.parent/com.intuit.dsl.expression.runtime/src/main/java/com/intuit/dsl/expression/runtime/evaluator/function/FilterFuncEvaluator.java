package com.intuit.dsl.expression.runtime.evaluator.function;

import static com.intuit.dsl.expression.runtime.util.JSONUtils.MAPPER;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.FilterFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import java.util.Iterator;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FilterFuncEvaluator implements Evaluator<FilterFunc> {

  ExpressionEvaluator expressionEvaluator;

  public FilterFuncEvaluator(ExpressionEvaluator visitor) {
    this.expressionEvaluator = visitor;
  }

  @Override
  public DataValue evaluate(final FilterFunc filter) {
    DataValue value = expressionEvaluator.doSwitch(filter.getExp());
    try {
      if (Objects.nonNull(filter.getCondtion())) {
        return filter(value, filter.getCondtion(), expressionEvaluator);
      }
    } catch (Exception e) {
      log.debug("Exception caught in filter function " + e.getMessage());
      return value;
    }
    return value;
  }

  public static DataValue filter(DataValue value, Expression condition, ExpressionEvaluator expressionEvaluator) {
    final boolean numberPragma = expressionEvaluator.getRuntimeOptions().getNumberPragma();

    if (value.getType() == DataValue.Type.ARRAY) {
      ArrayNode resultNode = MAPPER.createArrayNode();
      ArrayNode array = (ArrayNode) value.getValue();
      Iterator<JsonNode> iter = array.elements();
      while (iter.hasNext()) {
        JsonNode local = iter.next();
        ExpressionEvaluator expressionVisitor = expressionEvaluator.transform(builder -> {
          builder.withParentVisitor(expressionEvaluator);
          builder.withInputs(new JsonModel(local, numberPragma).fields());
        });
        if (expressionVisitor.doSwitch(condition).toBoolean()) {
          resultNode.add(local);
        }
      }
      return new DataValue(resultNode, DataValue.Type.ARRAY, numberPragma);
    }
    return value;
  }

}
