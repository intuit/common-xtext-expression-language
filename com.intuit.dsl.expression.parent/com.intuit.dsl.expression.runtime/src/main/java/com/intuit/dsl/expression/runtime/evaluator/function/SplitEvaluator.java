package com.intuit.dsl.expression.runtime.evaluator.function;

import static com.intuit.dsl.expression.runtime.util.JSONUtils.MAPPER;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.intuit.dsl.expression.Split;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataValue;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SplitEvaluator implements Evaluator<Split> {

  ExpressionEvaluator visitor;


  public SplitEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Split split) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();
    DataValue value = visitor.doSwitch(split.getExp());
    if (Objects.isNull(value)) {
      return new DataValue(null, DataValue.Type.NULL);
    }
    if (value.getType() == DataValue.Type.STRING || value.getType() == DataValue.Type.NUMBER) {
      ArrayNode list = MAPPER.createArrayNode();
      String[] words = value.toString().split(split.getRegex());
      // TODO: Need to return a proper DataValue.
      for (String word : words) {
        list.add(new TextNode(word));
      }
      return new DataValue(list, DataValue.Type.ARRAY, numberPragma);

    }
    return value;
  }

}
