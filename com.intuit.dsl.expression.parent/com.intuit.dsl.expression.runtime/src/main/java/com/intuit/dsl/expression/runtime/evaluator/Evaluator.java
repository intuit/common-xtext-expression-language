package com.intuit.dsl.expression.runtime.evaluator;

import com.intuit.dsl.expression.runtime.exception.ExpressionEvaluationException;
import com.intuit.dsl.expression.runtime.model.DataValue;
import org.eclipse.emf.ecore.EObject;

public interface Evaluator<T extends EObject> {

  default DataValue evaluate(T expression) {
    throw new ExpressionEvaluationException(
        String.format("No evaluator found for expresion: {%s}", expression.toString()));
  }

}
