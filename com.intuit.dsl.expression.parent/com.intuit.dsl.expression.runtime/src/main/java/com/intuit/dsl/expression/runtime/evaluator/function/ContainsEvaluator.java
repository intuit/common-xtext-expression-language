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
import java.util.stream.StreamSupport;

@Slf4j
public class ContainsEvaluator implements Evaluator<Contains> {

  ExpressionEvaluator visitor;


  public ContainsEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Contains contains) {
    DataValue input = visitor.doSwitch(contains.getInput());

    if (input.getType() == DataValue.Type.STRING || input.getType() == DataValue.Type.NUMBER) {
      DataValue search = visitor.doSwitch(contains.getSearch());
      if (search.getType() == DataValue.Type.STRING || search.getType() == DataValue.Type.NUMBER) {
        return new DataValue(input.toString().contains(search.toString()), DataValue.Type.BOOLEAN);
      }
    }
    if (input.getType() == DataValue.Type.ARRAY) {
      DataValue search = visitor.doSwitch(contains.getSearch());
      ArrayNode arrayNode = ArrayNode.class.cast(input.getValue());
      if (search.getType() == DataValue.Type.STRING || search.getType() == DataValue.Type.NUMBER) {
        return new DataValue(containsElementWithSubString(arrayNode, search.toString()), DataValue.Type.BOOLEAN);
      }
    }
    return new DataValue(false, DataValue.Type.BOOLEAN);
  }

  private boolean containsElementWithSubString(ArrayNode arrayNode, String subsString) {
    return StreamSupport
      .stream(arrayNode.spliterator(), false)
      .filter(jsonNode -> jsonNode.isNumber() || jsonNode.isTextual() )
      .map(jsonNode -> {
        if (jsonNode.isNumber()) {
          return jsonNode.decimalValue().toString();
        }
        if (jsonNode.isTextual()) {
          return jsonNode.asText();
        }
        return null;
      })
      .filter(Objects::nonNull)
      .anyMatch(string -> string.contains(subsString));
  }

}
