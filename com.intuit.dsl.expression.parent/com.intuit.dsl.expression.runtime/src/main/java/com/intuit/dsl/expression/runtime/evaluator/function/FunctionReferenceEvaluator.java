package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.FunctionReference;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FunctionReferenceEvaluator implements Evaluator<FunctionReference> {

  ExpressionEvaluator visitor;

  public FunctionReferenceEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final FunctionReference functionReference) {
    return visitor.doSwitch(functionReference.getRef());

  }
}
