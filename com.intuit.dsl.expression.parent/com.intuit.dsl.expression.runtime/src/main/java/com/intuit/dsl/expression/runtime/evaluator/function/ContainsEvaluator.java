package com.intuit.dsl.expression.runtime.evaluator.function;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.intuit.dsl.expression.Contains;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

@Slf4j
public class ContainsEvaluator implements Evaluator<Contains> {

  ExpressionEvaluator visitor;


  public ContainsEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Contains contains) {
    DataValue input = visitor.doSwitch(contains.getInput());
    if (input.getType() == DataValue.Type.NULL)
      return new DataValue(false, DataValue.Type.BOOLEAN);

    if (input.getType() == DataValue.Type.STRING || input.getType() == DataValue.Type.NUMBER) {
      DataValue search = visitor.doSwitch(contains.getSearch());
      if (search.getType() == DataValue.Type.NULL) new DataValue(false, DataValue.Type.BOOLEAN);
      if (search.getType() == DataValue.Type.STRING || search.getType() == DataValue.Type.NUMBER) {
        return new DataValue(input.toString().contains(search.toString()), DataValue.Type.BOOLEAN);
      }
    }
    if (input.getType() == DataValue.Type.ARRAY) {
      DataValue search = visitor.doSwitch(contains.getSearch());
      ArrayNode arrayNode = ArrayNode.class.cast(input.getValue());
      if (search.getType() == DataValue.Type.NULL) new DataValue(false, DataValue.Type.BOOLEAN);
      if (search.getType() == DataValue.Type.STRING) {
        return new DataValue(containsElementWithSubString(arrayNode, (String)search.getValue()), DataValue.Type.BOOLEAN);
      }
      if (search.getType() == DataValue.Type.NUMBER) {
        return new DataValue(containsNumber(arrayNode, (NumberValue)search.getValue()), DataValue.Type.BOOLEAN);
      }
    }
    return new DataValue(false, DataValue.Type.BOOLEAN);
  }

  private Object containsNumber(ArrayNode arrayNode, NumberValue numberToSearch) {
    for (JsonNode jsonNode : arrayNode) {
      if (jsonNode.isNumber() && !Objects.isNull(jsonNode.decimalValue())) {
        if (jsonNode.decimalValue().equals(numberToSearch.get())) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean containsElementWithSubString(ArrayNode arrayNode, String subsString) {
    for (JsonNode jsonNode : arrayNode) {
      if (jsonNode.isTextual() && !Objects.isNull(jsonNode.asText())) {
        if (jsonNode.asText().contains(subsString)) {
          return true;
        }
      }
    }
    return false;
  }

}
