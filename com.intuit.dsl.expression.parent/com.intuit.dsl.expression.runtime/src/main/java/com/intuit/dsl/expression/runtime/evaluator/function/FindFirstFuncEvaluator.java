package com.intuit.dsl.expression.runtime.evaluator.function;

import static com.intuit.dsl.expression.runtime.evaluator.function.FilterFuncEvaluator.filter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.intuit.dsl.expression.FindFirstFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FindFirstFuncEvaluator implements Evaluator<FindFirstFunc> {

  ExpressionEvaluator visitor;


  public FindFirstFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final FindFirstFunc findFirstFunc) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    DataValue value = visitor.doSwitch(findFirstFunc.getExp());
    try {
      if (Objects.nonNull(findFirstFunc.getCondition())) {
        DataValue filterValue = filter(value, findFirstFunc.getCondition(), visitor);
        ArrayNode matchingElements = (ArrayNode) (filterValue != null ? filterValue.getValue() : null);
        if (Objects.isNull(matchingElements) || matchingElements.size() == 0) {
          return new DataValue(null, DataValue.Type.NULL);
        } else {
          JsonNode el = matchingElements.get(0);
          return new DataValue(el, EvaluatorUtils.getType(el), numberPragma);
        }
      }
    } catch (Exception e) {
      log.debug("Exception caught in find function " + e.getMessage());
    }
    return new DataValue(null, DataValue.Type.NULL);

  }



}
