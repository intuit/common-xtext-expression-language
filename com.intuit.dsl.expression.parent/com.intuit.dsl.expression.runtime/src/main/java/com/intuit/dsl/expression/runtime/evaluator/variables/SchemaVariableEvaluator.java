package com.intuit.dsl.expression.runtime.evaluator.variables;

import com.intuit.dsl.expression.SchemaVariable;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchemaVariableEvaluator implements Evaluator<SchemaVariable> {

  ExpressionEvaluator visitor;

  public SchemaVariableEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final SchemaVariable variable) {
    DataModel valueFromMap = EvaluatorUtils.getKeyFromInputMap(variable.getKey().get(0), visitor);
    return EvaluatorUtils.getKeys(variable.getKey(), valueFromMap,1,visitor);
  }

}
