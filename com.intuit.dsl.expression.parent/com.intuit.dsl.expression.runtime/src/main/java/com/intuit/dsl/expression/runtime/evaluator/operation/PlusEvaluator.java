package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.Plus;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.util.Objects;

public class PlusEvaluator implements Evaluator<Plus> {

  ExpressionEvaluator visitor;

  public PlusEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Plus plus) {
    DataValue left = visitor.doSwitch(plus.getLeft());
    DataValue right = visitor.doSwitch(plus.getRight());

    if (Objects.isNull(left) || left.getType() == DataValue.Type.NULL) {
      return right;
    }
    if (Objects.isNull(right) || right.getType() == DataValue.Type.NULL) {
      return left;
    }
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    // Support string concatenation or adding numbers.
    if (left.getType() == DataValue.Type.NUMBER && right.getType() == DataValue.Type.NUMBER) {
      return new DataValue(((NumberValue) left.getValue()).add((NumberValue) right.getValue()), DataValue.Type.NUMBER,
          numberPragma);
    } else {
      return new DataValue(left.getValue().toString() + right.getValue().toString(), DataValue.Type.STRING);
    }
  }
}
