package com.intuit.dsl.expression.runtime.evaluator.function;

import com.fasterxml.jackson.databind.JsonNode;
import com.intuit.dsl.expression.Json;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.JSONUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonEvaluator implements Evaluator<Json> {

  ExpressionEvaluator visitor;


  public JsonEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Json toJson) {
    DataValue value = visitor.doSwitch(toJson.getExp());
//		if (value.type == DataValue.Type.TSI) {
//			return new TSIModel(new TsiMapVal(value.value), pragmas.numberPragma).json
//		} else if (value.type == DataValue.Type.STRING) {
    try {
      JsonNode json = JSONUtils.getJSONFromString(value.getValue().toString());
      return new DataValue(json, DataValue.Type.OBJECT, visitor.getRuntimeOptions().getNumberPragma());
    } catch (Exception e) {
      log.debug("Exception caught in json function " + e.getMessage());
    }
//		}
    return value;
  }


}
