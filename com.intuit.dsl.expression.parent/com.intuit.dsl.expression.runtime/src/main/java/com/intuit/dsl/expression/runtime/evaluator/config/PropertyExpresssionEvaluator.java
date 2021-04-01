package com.intuit.dsl.expression.runtime.evaluator.config;

import com.intuit.dsl.expression.PropertyExpresssion;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyExpresssionEvaluator implements Evaluator<PropertyExpresssion> {

  ExpressionEvaluator visitor;

  public PropertyExpresssionEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final PropertyExpresssion variableRef) {
    return visitor.doSwitch(variableRef.getRef());
  }
}
