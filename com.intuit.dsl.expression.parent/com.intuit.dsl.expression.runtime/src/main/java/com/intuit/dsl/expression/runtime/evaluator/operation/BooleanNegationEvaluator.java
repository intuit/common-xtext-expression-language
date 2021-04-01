package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.BooleanNegation;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class BooleanNegationEvaluator implements Evaluator<BooleanNegation> {

  ExpressionEvaluator visitor;

  public BooleanNegationEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final BooleanNegation booleanNegation) {

    DataValue value = visitor.doSwitch(booleanNegation.getExpression());
    if (Objects.isNull(value) || value.getType() == DataValue.Type.NULL) {
      return new DataValue(true, DataValue.Type.BOOLEAN);
    } else if (value.getType() != DataValue.Type.BOOLEAN) {
      return new DataValue(StringUtils.equalsAny(value.getValue().toString(), "", "0"),
          DataValue.Type.BOOLEAN);
    } else {
      return new DataValue(!(value.toBoolean()), DataValue.Type.BOOLEAN);
    }
  }
}
