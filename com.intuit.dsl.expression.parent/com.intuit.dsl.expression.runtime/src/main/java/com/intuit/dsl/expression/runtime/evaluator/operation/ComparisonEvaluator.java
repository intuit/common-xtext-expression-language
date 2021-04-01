package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.Comparison;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.util.Objects;

public class ComparisonEvaluator implements Evaluator<Comparison> {

  ExpressionEvaluator visitor;

  public ComparisonEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Comparison comparison) {
    DataValue left = visitor.doSwitch(comparison.getLeft());

    if (Objects.isNull(left) || left.getType() != DataValue.Type.NUMBER) {
      return (new DataValue(false, DataValue.Type.BOOLEAN));
    }

    DataValue right = visitor.doSwitch(comparison.getRight());
    if (Objects.isNull(right) || right.getType() != DataValue.Type.NUMBER) {
      return (new DataValue(false, DataValue.Type.BOOLEAN));
    }

    NumberValue leftValue = (NumberValue) left.getValue();
    NumberValue rightValue = (NumberValue) right.getValue();
    String op = comparison.getOp();
    switch (op) {
      case ">":
        return (new DataValue(leftValue.greater(rightValue), DataValue.Type.BOOLEAN));
      case "<":
        return (new DataValue(leftValue.less(rightValue), DataValue.Type.BOOLEAN));
      case ">=":
        return (new DataValue(leftValue.greaterEqual(rightValue), DataValue.Type.BOOLEAN));
      case "<=":
        return (new DataValue(leftValue.lessEqual(rightValue), DataValue.Type.BOOLEAN));
      default:
        return (new DataValue(false, DataValue.Type.BOOLEAN));
    }
  }
}
