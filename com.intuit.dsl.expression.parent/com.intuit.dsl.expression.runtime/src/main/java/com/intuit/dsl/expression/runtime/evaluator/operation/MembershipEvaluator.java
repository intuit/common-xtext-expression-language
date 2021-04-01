package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.Membership;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Iterator;

public class MembershipEvaluator implements Evaluator<Membership> {

  ExpressionEvaluator visitor;

  public MembershipEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Membership membership) {
    final DataValue left = visitor.doSwitch(membership.getLeft());
    Iterator<Expression> valueIterator = membership.getRight().iterator();
    boolean isIn = (membership.getOp().equals("in"));
    while (valueIterator.hasNext()) {
      DataValue right = visitor.doSwitch(valueIterator.next());
      if (left.equals(right)) {
        return new DataValue(isIn, DataValue.Type.BOOLEAN);
      }
    }
    return new DataValue(!isIn, DataValue.Type.BOOLEAN);
  }
}
