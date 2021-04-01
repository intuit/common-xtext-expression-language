package com.intuit.dsl.expression.runtime.evaluator.function;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.intuit.dsl.expression.LastFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LastFuncEvaluator implements Evaluator<LastFunc> {

  ExpressionEvaluator visitor;


  public LastFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final LastFunc lastFunc) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    DataValue dataValue = visitor.doSwitch(lastFunc.getExp());

    if (dataValue.getType() == DataValue.Type.ARRAY) {
      ArrayNode container = (ArrayNode)dataValue.getValue();
      if (Objects.isNull(container) || container.size() == 0) {
        return new DataValue(null, DataValue.Type.NULL);
      }

      JsonNode last = container.get(container.size() - 1).deepCopy();

      return new DataValue(last, EvaluatorUtils.getType(last), numberPragma);
    }

    return dataValue;

  }

}
