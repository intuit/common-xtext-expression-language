package com.intuit.dsl.expression.runtime.evaluator.variables;

import com.intuit.dsl.expression.VariableReference;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VariableReferenceEvaluator implements Evaluator<VariableReference> {

  ExpressionEvaluator visitor;

  public VariableReferenceEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final VariableReference variableRef) {
    if (Objects.nonNull(variableRef.getRef().getSchemaVariable().getGlobal()) && visitor.getParentVisitor().isPresent()) {
      //This is for backward compatibility of :: operator
      return visitor.getParentVisitor().get().doSwitch(variableRef.getRef());
    }
    return visitor.doSwitch(variableRef.getRef());
  }
}
