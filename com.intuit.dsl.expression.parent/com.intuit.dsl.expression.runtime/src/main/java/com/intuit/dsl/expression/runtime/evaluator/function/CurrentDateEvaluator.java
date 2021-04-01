package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.CurrentDate;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import com.intuit.dsl.expression.runtime.util.DateUtils;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class CurrentDateEvaluator implements Evaluator<CurrentDate> {

  ExpressionEvaluator visitor;


  public CurrentDateEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final CurrentDate currentDate) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    if (StringUtils.equals(StringUtils.remove(currentDate.getFormat(), '"'),"ms")) {
      return new DataValue(new NumberValue(new Date().getTime(), numberPragma), DataValue.Type.NUMBER,
          numberPragma);
    }
    return new DataValue(DateUtils.currentDate(currentDate.getFormat()), DataValue.Type.STRING, numberPragma);
  }

}
