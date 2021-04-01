package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.Equals;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import org.apache.commons.lang3.StringUtils;

public class EqualsEvaluator implements Evaluator<Equals> {

  ExpressionEvaluator visitor;

  public EqualsEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Equals equals) {
    DataValue left = visitor.doSwitch(equals.getLeft());
    DataValue right = visitor.doSwitch(equals.getRight());

    String op = equals.getOp();
    if (StringUtils.equals(op, "!=")) {
      return new DataValue(left != right, DataValue.Type.BOOLEAN);
    } else if (StringUtils.equals(op, "=~")) {
      return new DataValue(left.fuzzyEquals(right), DataValue.Type.BOOLEAN);
    } else if (StringUtils.equals(op, "!~")) {
      return new DataValue(!left.fuzzyEquals(right), DataValue.Type.BOOLEAN);
    } else {
      return new DataValue(left == right, DataValue.Type.BOOLEAN);
    }
  }
}
