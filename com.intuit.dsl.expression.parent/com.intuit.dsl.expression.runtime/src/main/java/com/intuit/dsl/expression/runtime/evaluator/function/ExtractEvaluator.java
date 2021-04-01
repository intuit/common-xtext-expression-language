package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.Extract;
import com.intuit.dsl.expression.Range;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Iterator;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExtractEvaluator implements Evaluator<Extract> {

  ExpressionEvaluator visitor;


  public ExtractEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final Extract extract) {
    try {
      DataValue input = visitor.doSwitch(extract.getInput());
      return extract(input, extract.getRange(), visitor);
    } catch (Exception e) {
      log.debug("Exception caught in extract function " + e.getMessage());
      return new DataValue(null, DataValue.Type.NULL);
    }
  }

  public static DataValue extract(DataValue input, Range range, ExpressionEvaluator visitor) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    if (input.getType() == DataValue.Type.STRING || input.getType() == DataValue.Type.NUMBER) {
      Long low = EvaluatorUtils.getLowRangeValue(visitor, range);
      Long high = EvaluatorUtils.getHighRangeValue(visitor, range, input);
      return new DataValue(input.toString().substring(low.intValue(), high.intValue()), DataValue.Type.STRING,
          numberPragma);
    } else if (input.getType() == DataValue.Type.ARRAY) {
      Long low = EvaluatorUtils.getLowRangeValue(visitor, range);
      Long high = EvaluatorUtils.getHighRangeValue(visitor, range, input);
      DataModel resultNode = JsonModel.arrayNode(numberPragma);
      Iterator<DataModel> iter = new JsonModel(input, numberPragma).toList().iterator();
      long index = 0;
      while (iter.hasNext()) {
        DataModel local = iter.next();
        if (index >= low && index < high) {
          resultNode.add(local);
        }
        index++;
      }
      return resultNode.getValue();
    }
    return new DataValue(null, DataValue.Type.NULL);
  }

}
