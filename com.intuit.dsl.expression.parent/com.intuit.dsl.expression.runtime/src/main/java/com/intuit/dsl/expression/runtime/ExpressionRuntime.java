package com.intuit.dsl.expression.runtime;

import static com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator.newExpressionEvaluator;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.xtext.resource.XtextResource;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.Maps;
import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import com.intuit.dsl.expression.runtime.model.RuntimeOptions;
import com.intuit.dsl.expression.runtime.parser.XtextExpressionParser;

public class ExpressionRuntime {

  private static Map<String, Expression> CACHE = new ConcurrentHashMap<>();
  private String expressionContent;
  private Map<String, JsonNode> data = new HashMap<>();
  private RuntimeOptions options = new RuntimeOptions();
  private ConfigManager configManager = new ConfigManager() {};

  private ExpressionRuntime() {}

  public static ExpressionRuntime newExpressionRuntime() {
    return new ExpressionRuntime();
  }

  public ExpressionRuntime withExpressionContent(final String expressionContent) {
    this.expressionContent = expressionContent;
    return this;
  }

  public ExpressionRuntime withData(final Map<String, JsonNode> data) {
    this.data = data;
    return this;
  }

  public ExpressionRuntime withOptions(final RuntimeOptions options) {
    this.options = options;
    return this;
  }

  public ExpressionRuntime withConfigManager(final ConfigManager manager) {
    this.configManager = manager;
    return this;
  }

  public DataValue evaluate() throws IOException {

    Expression expression = getExpression();
    Objects.requireNonNull(expression, "No expression found");
    return newExpressionEvaluator()
        .withInputs(
            Maps.transformValues(data, value -> new JsonModel(value, options.getNumberPragma())))
        .withOptions(options).withConfigManager(configManager).build().doSwitch(expression);
  }

  private Expression getExpression() throws IOException {
    Objects.requireNonNull(expressionContent, "Expression content not provided");
    Expression expFromCache = CACHE.get(expressionContent);
    if (Objects.nonNull(expFromCache)) {
      return expFromCache;
    }
    XtextResource resource = new XtextExpressionParser().parse(expressionContent);
    Objects.requireNonNull(resource, "Xtext resouce cannot be null");
    Expression expression = (Expression) resource.getContents().get(0);
    Objects.requireNonNull(expression, "No expression found to evaluate");
    CACHE.put(expressionContent, expression);
    return expression;
  }

}
