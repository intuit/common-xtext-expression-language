package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.DateFormat;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DateFormatEvaluator implements Evaluator<DateFormat> {

  ExpressionEvaluator visitor;


  public DateFormatEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final DateFormat date) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    DataValue value = visitor.doSwitch(date.getExp());
    if (Objects.isNull(value) || value.getType() == DataValue.Type.NULL)
      return new DataValue(null, DataValue.Type.NULL);
    try {
      String toDate = StringUtils.remove((date.getTo()), '"');
      String fromDate = StringUtils.remove((date.getFrom()), '"');
       SimpleDateFormat fromFormatter = new SimpleDateFormat(fromDate);
       SimpleDateFormat toFormatter = new SimpleDateFormat(toDate);
      if (StringUtils.equals(toDate,fromDate)) {
        return new DataValue(value.getValue(), DataValue.Type.STRING, numberPragma);
      } else if (StringUtils.equals(toDate, "ms")) {
        return new DataValue(
            new NumberValue(fromFormatter.parse(value.getValue().toString()).getTime(), numberPragma),
            DataValue.Type.NUMBER, numberPragma);
      } else if (StringUtils.equals(fromDate, "ms")) {
        Calendar calendar = Calendar.getInstance();
        long milliSeconds = Long.parseLong(value.getValue().toString());
        calendar.setTimeInMillis(milliSeconds);
        return new DataValue(toFormatter.format(calendar.getTime()), DataValue.Type.STRING,
            numberPragma);
      } else {
        return new DataValue(toFormatter.format(fromFormatter.parse(value.getValue().toString())),
            DataValue.Type.STRING,numberPragma);
      }
    } catch (Exception ex) {
      // invalid date we are going to convert to string and replace special characters.
      // -'-' are send.
      log.debug("Invalid date type conversion", date.toString());
      return new DataValue(StringUtils.remove(value.toString(), '-'), DataValue.Type.STRING, numberPragma);
    }
  }

}
