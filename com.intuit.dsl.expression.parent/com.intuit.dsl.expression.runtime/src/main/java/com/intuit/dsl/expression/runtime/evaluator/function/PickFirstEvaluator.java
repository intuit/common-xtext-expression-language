package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.PickFirst;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PickFirstEvaluator implements Evaluator<PickFirst> {

  ExpressionEvaluator visitor;
  public static final String IT = "it";


  public PickFirstEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final PickFirst pickFirst) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    for (Expression expression : pickFirst.getExp()) {
      DataValue expressionValue = visitor.doSwitch(expression);
      //ToDo: Review this put
      visitor.getInputs().put(IT, new JsonModel(expressionValue, numberPragma));
      if ((visitor.doSwitch(pickFirst.getCondition())).toBoolean()) {
        return expressionValue;
      }
    }
    return new DataValue(null, DataValue.Type.NULL);
  }
}
