package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.DayDifference;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import com.intuit.dsl.expression.runtime.util.DateUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DayDifferenceEvaluator implements Evaluator<DayDifference> {

  ExpressionEvaluator visitor;

  public DayDifferenceEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final DayDifference dayDifference) {
    // From might be a String or a Function
    String from = visitor.doSwitch(dayDifference.getFrom()).toString();
    // To might be a String or a Function
    String to = visitor.doSwitch(dayDifference.getTo()).toString();
    // The formatter has double quotes in it that need to be stripped
    String formatter = dayDifference.getFormatter().replace("\"", "");
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    // Returning the difference in days
    return new DataValue(new NumberValue(DateUtils.dayDifference(from, to, formatter), numberPragma),
        DataValue.Type.NUMBER, numberPragma);
  }
}
