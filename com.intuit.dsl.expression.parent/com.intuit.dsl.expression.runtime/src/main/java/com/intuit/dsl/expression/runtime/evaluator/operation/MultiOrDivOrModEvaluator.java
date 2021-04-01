package com.intuit.dsl.expression.runtime.evaluator.operation;

import com.intuit.dsl.expression.MultiOrDivOrMod;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class MultiOrDivOrModEvaluator implements Evaluator<MultiOrDivOrMod> {

  ExpressionEvaluator visitor;

  public MultiOrDivOrModEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final MultiOrDivOrMod multiOrDivOrMod) {
    DataValue left = visitor.doSwitch(multiOrDivOrMod.getLeft());
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    if (Objects.isNull(left) || left.getType() == DataValue.Type.NULL) {
      return new DataValue(null, DataValue.Type.NULL);
    }

    DataValue right = visitor.doSwitch(multiOrDivOrMod.getRight());
    if (Objects.isNull(right) || right.getType() == DataValue.Type.NULL) {
      return new DataValue(null, DataValue.Type.NULL);
    }

    if (left.getType() == DataValue.Type.NUMBER && right.getType() == DataValue.Type.NUMBER) {
      if (StringUtils.equals(multiOrDivOrMod.getOp(), "*")) {
        return new DataValue(((NumberValue) left.getValue()).multiply(((NumberValue) right.getValue())),
            DataValue.Type.NUMBER, numberPragma);
      } else if (StringUtils.equals(multiOrDivOrMod.getOp(), "%")) {
        return new DataValue(((NumberValue) left.getValue()).remainder(((NumberValue) right.getValue())),
            DataValue.Type.NUMBER, numberPragma);
      } else {
        return new DataValue(((NumberValue) left.getValue()).divide(((NumberValue) right.getValue())),
            DataValue.Type.NUMBER, numberPragma);
      }
    } else {
      log.debug("You cannot multiply or divide strings");
      return new DataValue(null, DataValue.Type.NULL, numberPragma);
    }
  }
}
