package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.AddToDate;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class AddToDateEvaluator implements Evaluator<AddToDate> {

  ExpressionEvaluator visitor;


  public AddToDateEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final AddToDate date) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    DataValue value = visitor.doSwitch(date.getExp());
    DataValue givenDate = visitor.doSwitch(date.getDateExp());
    if (Objects.isNull(givenDate) || givenDate.getType() == DataValue.Type.NULL) {
      return new DataValue(null, DataValue.Type.NULL);
    }
    try {
      String format = StringUtils.remove((date.getFormat()), '"');
      SimpleDateFormat sdf = new SimpleDateFormat(format);
      Calendar calendar = Calendar.getInstance();
      if (value.getType() == DataValue.Type.NUMBER) {
        if (StringUtils.equals(format,"ms")) {
          calendar.setTime(sdf.parse(givenDate.getValue().toString()));
          calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(value.toString()));
          return new DataValue(sdf.format(calendar.getTime()), DataValue.Type.STRING,
              numberPragma);
        } else {
          calendar.setTime(new Date(Long.parseLong(givenDate.getValue().toString())));
          calendar.add(Calendar.DAY_OF_MONTH, Integer.parseInt(value.toString()));
          return new DataValue(calendar.getTimeInMillis(), DataValue.Type.STRING,
              numberPragma);
        }
      }
      return givenDate;
    } catch (Exception ex) {
      log.debug("Invalid date to add to", date.toString());
      return givenDate;
    }
  }

}
