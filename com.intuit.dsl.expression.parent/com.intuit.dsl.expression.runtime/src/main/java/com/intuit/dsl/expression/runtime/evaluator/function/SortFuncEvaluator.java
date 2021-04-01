package com.intuit.dsl.expression.runtime.evaluator.function;

import com.intuit.dsl.expression.SchemaVariable;
import com.intuit.dsl.expression.SortFunc;
import com.intuit.dsl.expression.runtime.evaluator.Evaluator;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.JsonModel;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class SortFuncEvaluator implements Evaluator<SortFunc> {

  ExpressionEvaluator visitor;
  static final String ORDER_DESCENDING = "descending";


  public SortFuncEvaluator(ExpressionEvaluator visitor) {
    this.visitor = visitor;
  }

  @Override
  public DataValue evaluate(final SortFunc sortFunc) {
    DataValue dataValue = visitor.doSwitch(sortFunc.getExp());
    if (dataValue.getType() == DataValue.Type.ARRAY) {
      return sort(dataValue, sortFunc.getKey(), sortFunc.getType(), visitor);
    }
    return dataValue;
  }

  public static DataValue sort(DataValue value, SchemaVariable key, String order, ExpressionEvaluator visitor) {
    final boolean numberPragma = visitor.getRuntimeOptions().getNumberPragma();

    List<DataModel> newList = new JsonModel(value, numberPragma).toList();
    Collections.sort(newList, (a, b) ->
    {
      String aValue = getValue(visitor, key, a.fields());
      String bValue = getValue(visitor, key, b.fields());
      int compareOutput = EvaluatorUtils.compareTo(aValue, bValue);
      return StringUtils.equals(order, ORDER_DESCENDING) ? compareOutput * -1 : compareOutput;
    });
    return new DataValue(newList, DataValue.Type.ARRAY, numberPragma);
  }


  private static String getValue(ExpressionEvaluator expressionEvaluator, SchemaVariable key,
      Map<String, DataModel> inputMap) {
    ExpressionEvaluator expressionVisitor = expressionEvaluator.transform(builder -> {
      builder.withParentVisitor(expressionEvaluator);
      builder.withInputs(inputMap);
    });
    DataValue value = expressionVisitor.doSwitch(key);
    return value != null ? value.toString() : null;
  }
}
