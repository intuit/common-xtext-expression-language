package com.intuit.dsl.expression.runtime.evaluator.function;

import static com.intuit.dsl.expression.runtime.util.JSONUtils.MAPPER;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.intuit.dsl.expression.ConcatFunc;
import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Iterator;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcatFuncEvaluator implements Evaluator<ConcatFunc> {

  ExpressionEvaluator visitor;


  public ConcatFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final ConcatFunc concat) {
    StringBuilder result = new StringBuilder();
    ArrayNode list = MAPPER.createArrayNode();
    DataValue.Type type = DataValue.Type.NULL;
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    try {
      for (Expression e : concat.getExp()) {
        DataValue value = visitor.doSwitch(e);
        if (Objects.nonNull(value) && value.getType() != DataValue.Type.NULL) {
          if (value.getType() == DataValue.Type.STRING || value.getType() == DataValue.Type.NUMBER) {
            if (type == DataValue.Type.NULL) {
              type = DataValue.Type.STRING;
            }
            result.append(value);
          } else {
            if (value.getType() == DataValue.Type.ARRAY) {
              if (type == DataValue.Type.NULL) {
                type = DataValue.Type.ARRAY;
              }
              Iterator<JsonNode> iter = ((ArrayNode) value.getValue()).elements();
              while (iter.hasNext()) {
                list.add(iter.next());
              }
            } else {
              list.add((JsonNode) value.getValue());
            }
          }
        } else {
          log.debug("Null argument in Concat function ");
        }
      }
    } catch (Exception e) {
      log.debug("Exception caught in Concat function " + e.getMessage());
      return new DataValue(null, DataValue.Type.NULL);
    }
    if (type == DataValue.Type.NULL) {
      return new DataValue(null, type);
    } else if (type == DataValue.Type.STRING) {
      return new DataValue(result.toString(), type, numberPragma);
    } else {
      return new DataValue(list, DataValue.Type.ARRAY, numberPragma);
    }
  }

}
