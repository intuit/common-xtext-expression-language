package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.Contains;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ContainsEvaluator implements Evaluator<Contains> {

  ExpressionEvaluator visitor;


  public ContainsEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Contains contains) {
    DataValue input = visitor.doSwitch(contains.getInput());
    if (input.getType() == DataValue.Type.NULL)
      return new DataValue(false, DataValue.Type.BOOLEAN);

    if (input.getType() == DataValue.Type.STRING || input.getType() == DataValue.Type.NUMBER) {
      DataValue search = visitor.doSwitch(contains.getSearch());
      if (search.getType() == DataValue.Type.NULL) new DataValue(false, DataValue.Type.BOOLEAN);
      if (search.getType() == DataValue.Type.STRING || search.getType() == DataValue.Type.NUMBER) {
        return new DataValue(input.toString().contains(search.toString()), DataValue.Type.BOOLEAN);
      }
    }
    return new DataValue(false, DataValue.Type.BOOLEAN);
  }

}
