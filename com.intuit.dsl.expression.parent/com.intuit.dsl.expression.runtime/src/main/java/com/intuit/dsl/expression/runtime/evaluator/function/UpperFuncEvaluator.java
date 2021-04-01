package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.UpperFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class UpperFuncEvaluator implements Evaluator<UpperFunc> {

  ExpressionEvaluator visitor;


  public UpperFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final UpperFunc lower) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    DataValue input = visitor.doSwitch(lower.getExp());
    if (input.getType() == DataValue.Type.STRING) {
      return new DataValue(StringUtils.upperCase(input.toString()), DataValue.Type.STRING, numberPragma);
    }
    return input;
  }

}
