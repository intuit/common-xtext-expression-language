package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.Minus;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinusEvaluator implements Evaluator<Minus> {

  ExpressionEvaluator visitor;

  public MinusEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Minus minus) {
    DataValue left = visitor.doSwitch(minus.getLeft());
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    if (Objects.isNull(left) || left.getType() == DataValue.Type.NULL) {
      left = new DataValue(new NumberValue(0, numberPragma), DataValue.Type.NUMBER, numberPragma);
    }

    DataValue right = visitor.doSwitch(minus.getRight());
    if (Objects.isNull(right) || right.getType() == DataValue.Type.NULL) {
      right = new DataValue(new NumberValue(0, numberPragma), DataValue.Type.NUMBER, numberPragma);
    }

    if (left.getType() == DataValue.Type.NUMBER && right.getType() == DataValue.Type.NUMBER) {
      return new DataValue(((NumberValue) left.getValue()).subtract(((NumberValue) right.getValue())),
          DataValue.Type.NUMBER, numberPragma);
    } else {
      log.debug("You cannot subtract from strings");
      return new DataValue(null, DataValue.Type.NULL, numberPragma);
    }
  }
}
