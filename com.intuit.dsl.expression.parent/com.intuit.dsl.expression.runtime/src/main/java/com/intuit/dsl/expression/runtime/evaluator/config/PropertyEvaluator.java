package com.intuit.dsl.expression.runtime.evaluator.config;

import com.intuit.dsl.expression.Property;
import com.intuit.dsl.expression.runtime.ConfigManager;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PropertyEvaluator implements Evaluator<Property> {

  ExpressionEvaluator visitor;

  public PropertyEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Property property) {
    ConfigManager configManager = visitor.getConfigManager();
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    return EvaluatorUtils.getPrimitiveValue(configManager.getProperty(property.getKey()), numberPragma);
  }
}
