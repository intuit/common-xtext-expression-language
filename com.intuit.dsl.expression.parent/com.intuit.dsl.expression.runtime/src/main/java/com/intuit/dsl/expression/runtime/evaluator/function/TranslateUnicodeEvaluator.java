package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.TranslateUnicode;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TranslateUnicodeEvaluator implements Evaluator<TranslateUnicode> {

  ExpressionEvaluator visitor;

  public TranslateUnicodeEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final TranslateUnicode translateUnicode) {
    DataValue value = visitor.doSwitch(translateUnicode.getExp());
    if (value.getType() != DataValue.Type.NULL) {
      return new DataValue(EvaluatorUtils.translateUnicode(value.toString()), DataValue.Type.STRING);
    }
    return value;
  }
}
