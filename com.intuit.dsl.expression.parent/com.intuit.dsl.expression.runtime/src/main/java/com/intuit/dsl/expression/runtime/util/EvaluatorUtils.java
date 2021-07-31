package com.intuit.dsl.expression.runtime.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.LongNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.Key;
import com.intuit.dsl.expression.Range;
import com.intuit.dsl.expression.runtime.evaluator.ExpressionEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.NumberValue;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.eclipse.emf.common.util.EList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class EvaluatorUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(EvaluatorUtils.class);

  private static final Pattern NUMBERPATTERN = Pattern.compile("^(-)?\\d+(\\.\\d*)?$");

  private static final Pattern INTPATTERN = Pattern.compile("^(-)?\\d+.0*$");

  private static final ObjectMapper MAPPER = JSONUtils.MAPPER;

  public static boolean isNumeric(final String str) {
    if ((str == null)) {
      return false;
    }
    return EvaluatorUtils.NUMBERPATTERN.matcher(str).matches();
  }

  public static boolean isBoolean(final String str) {
    return StringUtils.equalsAny(str, "true", "false");
  }

  public static DataValue getPrimitiveValue(final String str, final boolean numberPragma) {
    if (str == null) {
      return new DataValue(str, DataValue.Type.NULL, numberPragma);
    }
    if (isBoolean(str)) {
      return new DataValue(Boolean.valueOf(str), DataValue.Type.BOOLEAN, numberPragma);
    }
    if (isNumeric(str)) {
      return new DataValue(new NumberValue(new BigDecimal(str), numberPragma), DataValue.Type.NUMBER,
          numberPragma);
    }
    return new DataValue(str, DataValue.Type.STRING, numberPragma);
  }

  /**
   * This function unescapes Strings for Java
   *
   * @return String
   */
  public static String translateUnicode(final String unicode) {
    return StringEscapeUtils.unescapeJava(unicode);
  }

  /**
   * This function compares String values -> value1, value2, It tries to compare the numbers first a
   *
   * @param value1 The first String value
   * @param value2 The second String value
   * @return int The return value - positive or negative depending on the compareTo method
   */
  public static int compareTo(final String value1, final String value2) {
    if (StringUtils.equals(value1, value2)) {
      return 0;
    }
    if (value1 == null && value2 != null) {
      return -1;
    }
    if (value1 != null && value2 == null) {
      return 1;
    }
    if (isNumeric(value1) && isNumeric(value2)) {
      return new BigDecimal(value1).compareTo(new BigDecimal(value2));
    }
    return value1.compareTo(value2);
  }

  /**
   * This function returns a number node or a decimal node based on the value.
   *
   * @param value The string value
   * @return JsonNode The node returned.
   */
  public static JsonNode getNumberNode(final String value) {
    if (Objects.isNull(value)) {
      return null;
    }
    // check if it is a decimal/int number.
    if (NUMBERPATTERN.matcher(value).matches()) {
      // check if it is an integer number
      if (INTPATTERN.matcher(value).matches()) {
        try {
          return new LongNode(Long.parseLong(value.split("\\.")[0]));
        } catch (Exception e) {
          LOGGER.error("Exception caught in getNumberNode:" + e.getMessage());
          return new DecimalNode(new BigDecimal(value));
        }
      }
      return new DecimalNode(new BigDecimal(value));
    }
    return null;
  }

  public static void setPath(final ObjectNode node, final String path, final DataModel value) {
    ObjectNode temp = node;
    String[] keys = path.split("\\.");
    int keyLength = keys.length;
    for (int i = 0; i < keyLength - 1; i++) {
      String key = keys[i];
      if (!temp.has(key)) {
        temp.replace(key, MAPPER.createObjectNode());
      }
      temp = (ObjectNode) temp.get(key);
    }
    JsonNode valueToReplace = (Objects.nonNull(value) && Objects.nonNull(value.get()))
        ? (JsonNode) ((DataValue) value.get()).getValue()
        : NullNode.instance;
    temp.replace(keys[keyLength - 1], valueToReplace);
  }

  public static DataModel getPath(final DataModel node, final String path) {
    DataModel temp = node;
    String[] keys = path.split("\\.");
    for (final String key : keys) {
      {
        temp = temp.get(key);
        if (temp == null) {
          return null;
        }
      }
    }
    return temp;
  }

  public static DataValue.Type getType(final JsonNode data) {
    if ((data == null)) {
      return DataValue.Type.NULL;
    }
    if ((data instanceof ObjectNode)) {
      return DataValue.Type.OBJECT;
    }
    if ((data instanceof ArrayNode)) {
      return DataValue.Type.ARRAY;
    }
    if ((data instanceof BooleanNode)) {
      return DataValue.Type.BOOLEAN;
    }
    if ((data instanceof NumericNode)) {
      return DataValue.Type.NUMBER;
    }
    if ((data instanceof TextNode)) {
      return DataValue.Type.STRING;
    }
    return DataValue.Type.NULL;
  }

  public static DataModel getKeyFromInputMap(Key key, ExpressionEvaluator visitor) {
    Map<String,DataModel> inputMap = visitor.getInputs();
    DataModel dataModel = inputMap.get(key.getId());
    if (Objects.nonNull(key.getExp()) && Objects.nonNull(dataModel)) {
      DataValue value = visitor.doSwitch(key.getExp());
      return dataModel.get(value.toString());
    }
    return dataModel;
  }

  public static DataValue getKeys(EList<Key> keys, DataModel model, int start, ExpressionEvaluator visitor) {
    // Traverse through the path
    DataModel node = model;
    if (Objects.isNull(node)) {
      return new DataValue(null, DataValue.Type.NULL);
    }

    if (Objects.nonNull(keys)) {
      for (int i = start; i < keys.size(); i++) {
        node = getKey(keys.get(i), node, visitor);
        // if any node is null return null
        if (Objects.isNull(node)) {
          return new DataValue(null, DataValue.Type.NULL);
        }
      }
    }
    return node.getValue();
  }

  private static DataModel getKey(Key key, DataModel node, ExpressionEvaluator visitor) {
    Expression exp = key.getExp();
    String id = key.getId();
    if (Objects.nonNull(exp)) {
      DataValue value = visitor.doSwitch(exp);
      if (node.has(id)) {
        //ToDo
//				if (node instanceof TSIModel) {
//					return node.get(id + "-" + value.toString)
//				} else {
        DataModel container = node.get(id);
        return (Objects.isNull(container)) ? null : container.get(value.toString());
        //}
      }
      return null;
    } else {
      return node.get(id);
    }
  }

  public static long getLowRangeValue(ExpressionEvaluator visitor, Range range) {
    if (Objects.nonNull(range)) {
      return getRangeValue(visitor, range.getLow(), 0);
    } else {
      return 0;
    }
  }

  public static long getHighRangeValue(ExpressionEvaluator visitor, Range range,
      DataValue value) {
    if (Objects.nonNull(range)) {
      return getRangeValue(visitor, range.getHigh(), value.length().get().longValue());
    } else {
      return value.length().get().longValue();
    }
  }

  public static long getRangeValue(ExpressionEvaluator visitor,
      Expression exp, long defaultValue) {
    if (Objects.nonNull(exp)) {
      DataValue lowValue = visitor.doSwitch(exp);
      if (lowValue.getType() == DataValue.Type.NUMBER) {
        long value = ((NumberValue) lowValue.getValue()).get().longValue();
        if (value > 0) {
          return value;
        }
      } else {
        LOGGER.warn("Index not a number in getRangeValue");
      }
    }
    return defaultValue;
  }

  public static String joinKeys(List<Key> keys) {
    return StringUtils.join(keys.stream().map(Key::getId).iterator(), '.');
  }
}
