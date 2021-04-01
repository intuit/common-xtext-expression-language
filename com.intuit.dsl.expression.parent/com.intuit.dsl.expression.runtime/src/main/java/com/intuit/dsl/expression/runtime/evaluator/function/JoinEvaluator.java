package com.intuit.dsl.expression.runtime.evaluator.function;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.intuit.dsl.expression.Join;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import java.util.Iterator;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JoinEvaluator implements Evaluator<Join> {

  ExpressionEvaluator expressionEvaluator;

  public JoinEvaluator(ExpressionEvaluator visitor) {
    this.expressionEvaluator = visitor;
  }

  @Override
  public DataValue evaluate(final Join join) {
    DataValue value = expressionEvaluator.doSwitch(join.getExp());
    final boolean numberPragma = expressionEvaluator.getRuntimeOptions().getNumberPragma();
    try {
      // check if this is an array
      if (value.getType() == DataValue.Type.ARRAY) {
        StringBuilder result = new StringBuilder();
        ArrayNode array = (ArrayNode) value.getValue();
        Iterator<JsonNode> iter = array.elements();
        while (iter.hasNext()) {
          JsonNode local = iter.next();
          // evaluate key expression, then add it to the result
          if (Objects.nonNull(join.getKey())) {
            ExpressionEvaluator expressionVisitor = expressionEvaluator.transform(builder -> {
              builder.withParentVisitor(expressionEvaluator);
              builder.withInputs(new JsonModel(local, numberPragma).fields());
            });
            DataValue keyValue = expressionVisitor.doSwitch(join.getKey());
            if (Objects.nonNull(keyValue)) {
              result.append(keyValue);
              if (iter.hasNext()) {
                result.append(join.getDelimiter());
              }
            }
          }
        }
        // take care of the last element.
        if (!result.toString().isEmpty() && Objects.nonNull(join.getLast())) {
          int start = result.lastIndexOf(join.getDelimiter());
          if (start >= 0) {
            result.replace(start, start + join.getDelimiter().length(), join.getLast());
          }
        }
        return new DataValue(result.toString(), DataValue.Type.STRING, numberPragma);
      }

    } catch (Exception e) {
      log.debug("Exception caught in join function " + e.getMessage());
      return value;
    }
    return value;
  }
}
