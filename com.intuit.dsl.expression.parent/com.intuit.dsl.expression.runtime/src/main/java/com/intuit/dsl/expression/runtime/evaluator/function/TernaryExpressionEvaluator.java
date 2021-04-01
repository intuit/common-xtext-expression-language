package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.TernaryExpression;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TernaryExpressionEvaluator implements Evaluator<TernaryExpression> {

  ExpressionEvaluator visitor;


  public TernaryExpressionEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final TernaryExpression ternaryExpression) {
    DataValue value = visitor.doSwitch(ternaryExpression.getExpression());
    if (value.toBoolean())
      return visitor.doSwitch(ternaryExpression.getTruevalue());
    else if (Objects.nonNull(ternaryExpression.getFalsevalue()))
      return visitor.doSwitch(ternaryExpression.getFalsevalue());
    else
      return new DataValue(null, DataValue.Type.NULL);
  }


}
