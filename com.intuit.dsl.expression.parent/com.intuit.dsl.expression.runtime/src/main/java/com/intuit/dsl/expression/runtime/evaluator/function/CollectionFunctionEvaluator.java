package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.CollectionFunction;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CollectionFunctionEvaluator implements Evaluator<CollectionFunction> {

  ExpressionEvaluator visitor;

  public CollectionFunctionEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final CollectionFunction collection) {
    DataValue collectionResult = visitor.doSwitch(collection.getFunction());
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    if (collectionResult.getType() != DataValue.Type.NULL) {
      DataModel jsonModel = new JsonModel(collectionResult, numberPragma);
      if (Objects.nonNull(collection.getRefexp())) {
        DataValue index = visitor.doSwitch(collection.getRefexp());
        if (index.getType() != DataValue.Type.NULL) {
          jsonModel = jsonModel.get(index.toString());
        }
      }
      if (Objects.nonNull(collection.getResultKey())) {
        return EvaluatorUtils.getKeys(collection.getResultKey(), jsonModel, 0, visitor);
      }
      return jsonModel.getValue();
    }
    return collectionResult;
  }
}
