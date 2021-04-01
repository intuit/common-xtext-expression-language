package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.Delete;
import com.intuit.dsl.expression.SchemaVariable;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Objects;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DeleteEvaluator implements Evaluator<Delete> {

  ExpressionEvaluator expressionEvaluator;


  public DeleteEvaluator(ExpressionEvaluator visitor) {
    this.expressionEvaluator = visitor;
  }

  @Override
  public DataValue evaluate(final Delete delete) {
    SchemaVariable schemaVariable = delete.getVariable().getSchemaVariable();
    Stream<String> neutralizedPath = schemaVariable.getKey().stream().map(eachKey -> {
      if (Objects.nonNull(eachKey.getExp())) {
        DataValue value = expressionEvaluator.doSwitch(eachKey.getExp());
        if (value.getType() == DataValue.Type.STRING || value.getType() == DataValue.Type.NUMBER) {
          return eachKey.getId() + "-" + value.toString();
        }
      }
      return eachKey.getId();
    });

    DataModel node = EvaluatorUtils.getKeyFromInputMap(schemaVariable.getKey().get(0), expressionEvaluator);

    /* Since getKey is not recursive, we Iterate over parent hierarchy*/
    ExpressionEvaluator parent = expressionEvaluator.getParentVisitor().get();
    ExpressionEvaluator rparent = parent;
    while (Objects.isNull(node) && Objects.nonNull(rparent)) {
      node = EvaluatorUtils.getKeyFromInputMap(schemaVariable.getKey().get(0), parent);
      rparent = parent.getParentVisitor().get();
    }

    if (Objects.nonNull(node)) {
      String path = StringUtils.join(neutralizedPath.skip(1).iterator(), '.');
      node.delete(path);
    }
    return new DataValue(null, DataValue.Type.NULL);
  }


}
