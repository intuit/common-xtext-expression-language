package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.UUIDFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UUIDFuncEvaluator implements Evaluator<UUIDFunc> {

  ExpressionEvaluator visitor;


  public UUIDFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final UUIDFunc uuid) {
    return new DataValue(UUID.randomUUID().toString(), DataValue.Type.STRING,
        visitor.getRuntimeOptions().getNumberPragma());

  }

}
