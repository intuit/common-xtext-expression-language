package com.intuit.dsl.expression.runtime.evaluator.variables;

import com.intuit.dsl.expression.BooleanLiteral;
import com.intuit.dsl.expression.NullLiteral;
import com.intuit.dsl.expression.NumberLiteral;
import com.intuit.dsl.expression.StringLiteral;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;

public class LiteralEvaluators {

  private LiteralEvaluators(){}

  public static final Evaluator<BooleanLiteral> BOOLEAN_LITERAL = new Evaluator<BooleanLiteral>() {
    @Override
    public DataValue evaluate(final BooleanLiteral booleanLiteral) {
       return new DataValue(Boolean.parseBoolean(booleanLiteral.getValue()), DataValue.Type.BOOLEAN);
    }
  };

  public static final Evaluator<NumberLiteral> NUMBER_LITERAL = new Evaluator<NumberLiteral>() {
    @Override
    public DataValue evaluate(final NumberLiteral numberLiteral) {
      return new DataValue(new NumberValue(numberLiteral.getValue(),false), DataValue.Type.NUMBER);
    }
  };

  public static final Evaluator<NullLiteral> NULL_LITERAL = new Evaluator<NullLiteral>() {
    @Override
    public DataValue evaluate(final NullLiteral nullLiteral) {
      return new DataValue(null, DataValue.Type.NULL);
    }
  };

  public static final Evaluator<StringLiteral> STRING_LITERAL = new Evaluator<StringLiteral>() {
    @Override
    public DataValue evaluate(final StringLiteral stringLiteral) {
      return new DataValue(stringLiteral.getValue(), DataValue.Type.STRING);
    }
  };

}
