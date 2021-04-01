package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.Length;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LengthEvaluator implements Evaluator<Length> {

  ExpressionEvaluator visitor;


  public LengthEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Length length) {
    DataValue value = visitor.doSwitch(length.getExp());
    return new DataValue(value.length(), DataValue.Type.NUMBER, visitor.getRuntimeOptions().getNumberPragma());
  }

}
