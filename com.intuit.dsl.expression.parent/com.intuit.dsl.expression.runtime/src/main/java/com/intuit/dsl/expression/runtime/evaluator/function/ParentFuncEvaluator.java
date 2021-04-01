package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.ParentFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParentFuncEvaluator implements Evaluator<ParentFunc> {

  ExpressionEvaluator visitor;


  public ParentFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final ParentFunc parentFunc) {
    if (visitor.getParentVisitor().isPresent()) {
      return visitor.getParentVisitor().get().doSwitch(parentFunc.getExp());
    }
    return new DataValue(null, DataValue.Type.NULL);
  }

}
