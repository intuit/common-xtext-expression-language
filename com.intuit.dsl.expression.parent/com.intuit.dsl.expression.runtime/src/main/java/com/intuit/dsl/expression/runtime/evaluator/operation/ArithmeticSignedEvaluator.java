package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.ArithmeticSigned;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.util.Objects;

public class ArithmeticSignedEvaluator implements Evaluator<ArithmeticSigned> {

  ExpressionEvaluator visitor;

  public ArithmeticSignedEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final ArithmeticSigned arithmeticSigned) {
    final DataValue value = visitor.doSwitch(arithmeticSigned.getExpression());
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    if (Objects.isNull(value) || value.getType() != DataValue.Type.NUMBER) {
      return new DataValue(new NumberValue(0, numberPragma), DataValue.Type.NUMBER, numberPragma);
    }
    return new DataValue(((NumberValue) (value.getValue())).multiply(new NumberValue(-1, numberPragma)),
        DataValue.Type.NUMBER, numberPragma);
  }
}
