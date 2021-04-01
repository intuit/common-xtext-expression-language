package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.BooleanExpression;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class BooleanExpressionEvaluator implements Evaluator<BooleanExpression> {

  ExpressionEvaluator visitor;

  public BooleanExpressionEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final BooleanExpression booleanExpression) {
    DataValue left = visitor.doSwitch(booleanExpression.getLeft());

    String op = booleanExpression.getOp();
    if (StringUtils.equalsAny(op, "&&", "and")) {

      if (left.getType() != DataValue.Type.BOOLEAN || !(left.toBoolean())) {
        return new DataValue(false, DataValue.Type.BOOLEAN);
      }

      DataValue right = visitor.doSwitch(booleanExpression.getRight());

      if (right.getType() != DataValue.Type.BOOLEAN || Objects.isNull(right.getValue())) {
        return new DataValue(false, DataValue.Type.BOOLEAN);
      }

      return new DataValue((left.toBoolean() && right.toBoolean()), DataValue.Type.BOOLEAN);
    } else {

      if (left.getType() != DataValue.Type.BOOLEAN || Objects.isNull(left.getValue())) {
        left = new DataValue(false, DataValue.Type.BOOLEAN);
      }

      if (left.toBoolean()) {
        return left;
      }

      DataValue right = visitor.doSwitch(booleanExpression.getRight());
      if (right.getType() != DataValue.Type.BOOLEAN || !(right.toBoolean())) {
        return new DataValue(false, DataValue.Type.BOOLEAN);
      }

      return right;
    }
  }
}
