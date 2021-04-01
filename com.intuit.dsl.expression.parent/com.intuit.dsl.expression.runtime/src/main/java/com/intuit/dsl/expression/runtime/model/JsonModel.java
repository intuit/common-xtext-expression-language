package com.intuit.dsl.expression.runtime.model;

import static com.intuit.dsl.expression.runtime.util.JSONUtils.MAPPER;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.ValueNode;
import com.intuit.dsl.expression.runtime.model.DataValue.Type;
import com.intuit.dsl.expression.runtime.util.EvaluatorUtils;
import com.intuit.dsl.expression.runtime.util.JSONUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonModel implements DataModel {

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonModel.class);
  private JsonNode node;
  private DataValue.Type nodeType;
  private boolean numberPragma;
  private boolean isImmutable;

  public JsonModel(DataValue value, boolean numberPragma) {
    this.nodeType = value.getType();
    this.numberPragma = numberPragma;
    createModel(value.getValue());
  }

  public JsonModel(JsonNode node, boolean numberPragma) {
    this.node = node;
    this.numberPragma = numberPragma;
  }

  //	new(Entity entity, DataValue value, boolean numberPragma) {
//		// autoboxing support for data types, only supported for primitives.
//		// will not support values with sub hierachies, the type conversion will
//		// not happen for elements in the value hierachies
//		// that get copied over.
//		 this(EvaluatorUtils.getType(entity), value, numberPragma)
//	}
  protected JsonModel(DataValue.Type type, DataValue value, boolean numberPragma) {
    this.nodeType = type;
    createModel(value.getValue());
    this.numberPragma = numberPragma;
  }

  //	 static JsonModel nullNode(Entity entity, RuntimeOptions pragmas) {
//		return NullUtils.nullNode(EvaluatorUtils.getType(entity), pragmas)
//	}
  public static JsonModel objectNode(boolean numberPragma) {
    return new JsonModel(new DataValue(MAPPER.createObjectNode(), DataValue.Type.OBJECT, numberPragma),
        numberPragma);
  }

  public static JsonModel arrayNode(boolean numberPragma) {
    return new JsonModel(new DataValue(MAPPER.createArrayNode(), DataValue.Type.ARRAY, numberPragma), numberPragma);
  }

  public Object get() {
    return new DataValue(node, this.nodeType, numberPragma);
  }

  public DataValue getValue() {
    // check for null
    if (nodeType == DataValue.Type.NULL || node == null || node.isNull()) {
      return new DataValue(null, DataValue.Type.NULL, numberPragma);
    }
    // check for boolean
    if (nodeType == DataValue.Type.BOOLEAN || node instanceof BooleanNode) {
      return new DataValue(node.asBoolean(), DataValue.Type.BOOLEAN, numberPragma);
    }
    // check for string
    if (nodeType == DataValue.Type.STRING || node instanceof TextNode) {
      final String asText = node.asText();
      return (asText.equals("null"))
          ? new DataValue(null, DataValue.Type.NULL, numberPragma)
          : new DataValue(asText, DataValue.Type.STRING, numberPragma);
    }
    // check for number
    if (nodeType == DataValue.Type.NUMBER || node instanceof NumericNode) {
      return new DataValue(new NumberValue(node.toString(), numberPragma), DataValue.Type.NUMBER, numberPragma);
    }
    // always clone and return.
    // used for object assignments.
    return new DataValue(node, (node instanceof ArrayNode) ? DataValue.Type.ARRAY : DataValue.Type.OBJECT,
        numberPragma);
  }

  public void replace(String string, DataModel child) {
    if (isImmutable) {
      throw new UnsupportedOperationException("Cannot modify an immutable value");
    }
    if (this.node.isObject()) {
      if (child == null) {
        replace(string, NullNode.instance);
      } else if (string.contains(".")) {
        setPath(string, child);
      } else {
        replace(string, (JsonNode) ((DataValue) (child.get())).getValue());
      }
    } else {
      throw new IllegalArgumentException("Unsupported operation ");
    }
  }

  private void setPath(String path, DataModel child) {
    EvaluatorUtils.setPath((ObjectNode) (node), path, child);
  }

  private void replace(String string, JsonNode value) {
    ((ObjectNode) (node)).replace(string, value);
  }

  public boolean has(String string) {
    return this.node.has(string);
  }

  public DataModel get(String string) {
    JsonNode data = null;
    if (node == null) {
      return null;
    }
    if (node.isContainerNode()) {
      if (node.isArray()) {
        try {
          int index = Integer.parseInt(string);
          if (index >= 0 && index < node.size()) {
            data = node.get(index);
          }
        } catch (NumberFormatException nfe) {
          LOGGER.warn("Unsupported operation: index needs to be a number");
          return null;
        }

      } else if (node.isObject()) {
        data = node.get(string);
      }
    }
//		if (data == null) {
//			// Hack for Namespace handling, needs to be changed
//			data = XmlCustomizations.get(node, string)
//		}
    if (data == null) {
      return null;
    }
    //	data = XmlCustomizations.customValue(data)
    // return new JsonModel(new DataValue(data, createDataModel(data)));
    return new JsonModel(data, numberPragma);
  }

  public String asText() {
    return node.asText();
  }

  public String toString() {
    return node.toString();
  }

  public void set(String string, DataModel child) {
    replace(string, child);
  }

  public boolean isArray() {
    return this.node != null && this.node.isArray();
  }

  public void add(DataModel data) {
    if (isImmutable) {
      throw new UnsupportedOperationException("Cannot modify an immutable value");
    }
    if (isArray()) {
      ((ArrayNode) this.node).add((JsonNode) (((DataValue) (data.get())).getValue()));
    } else {
      throw new IllegalArgumentException("Not an array node");
    }
  }

  public boolean isAtomic() {
    return this.node instanceof ValueNode;
  }

  public boolean isTextual() {
    return this.node.isTextual();
  }

  public int length() {
    return this.node.size();
  }

  private void createModel(Object node) {
    // check for null type && making sure the type is null
    if (nodeType == null || nodeType == DataValue.Type.NULL || node == null) {
      this.nodeType = DataValue.Type.NULL;
    } else if (nodeType == DataValue.Type.STRING) {
      this.node = new TextNode(node.toString());
    } else if (nodeType == DataValue.Type.NUMBER) {
      this.node = EvaluatorUtils.getNumberNode(node.toString());
    } else if (nodeType == DataValue.Type.BOOLEAN) {
      this.node = BooleanNode.valueOf(BooleanUtils.toBoolean(node.toString()));
    } else if (isComplex(nodeType)) {
      if ((node instanceof JsonNode)) {
        this.node = (JsonNode) node;
      } else {
        // Hacky Serializer, TODO
        try {
          this.node = JSONUtils.getJSONFromString(node.toString());
        } catch (Exception e) {
          this.node = new TextNode(node.toString());
        }
      }
    } else {
      this.node = new TextNode(node.toString());
    }
  }

  private boolean isComplex(Type type) {
    return type == Type.ARRAY || type == Type.OBJECT || type == Type.TSI || type == Type.FRF;
  }

  public List<DataModel> toList() {
    final List<DataModel> list = new ArrayList<>();
    if (isArray()) {
      ((ArrayNode) (this.node)).iterator().forEachRemaining(f -> list.add(new JsonModel(f, numberPragma)));
    }
    return list;
  }

  public Map<String, DataModel> fields() {
    final Map<String, DataModel> fields = new HashMap<>();
    node.fields().forEachRemaining(f -> fields.put(f.getKey(), new JsonModel(f.getValue(), numberPragma)));
    return fields;
  }

  public void delete(String path) {
    if (isImmutable) {
      throw new UnsupportedOperationException("Cannot modify an immutable value");
    }
    if (node.isArray()) {
      try {
        ((ArrayNode) (node)).remove(Integer.parseInt(path));
      } catch (NumberFormatException e) {
      }
    } else if (node.isObject()) {
      ((ObjectNode) (node)).remove(path);
    }
  }

  public void addAll(List<DataModel> models) {
    if (isImmutable) {
      throw new UnsupportedOperationException("Cannot modify an immutable value");
    }
    if (!isArray()) {
      throw new IllegalArgumentException("Not an array node");
    }
    models.forEach(this::add);
  }

  public String toJson() {
    return toString();
  }

  public String toXml() {
    throw new UnsupportedOperationException("JsonModel does not support toXml method");
  }

  public byte[] toBinary() {
    throw new UnsupportedOperationException("JsonModel does not supporCt toBinary method");
  }

  @Override
  public DataModel copy() {
    if ((node != null && node.isContainerNode()) || isComplex(nodeType)) {
      node = node.deepCopy();
    }
    return this;
  }

  public void setImmutable(boolean immutable) {
    this.isImmutable = immutable;
  }

  public JsonModel copyOnWrite(DataModel parent, String parentKey) {
    // if parent is array, dont do anything
    if (Objects.nonNull(parent) && parent.isArray()) {
      return this;
    }

    // Do this only for object and array.
    if (Objects.nonNull(node) && node.isContainerNode()) {
       JsonNode tempNode = node;
      DataValue.Type type = DataValue.Type.OBJECT;

      // Create a copy
      if (node.isObject()) {
        ObjectNode copy = MAPPER.createObjectNode();
        node.fields().forEachRemaining(entry -> copy.replace(entry.getKey(), entry.getValue()));
        node = copy;
        type = DataValue.Type.OBJECT;
      }
      if (node.isArray()) {
        ArrayNode copy = MAPPER.createArrayNode();
        node.elements().forEachRemaining(element -> copy.add(element));
        node = copy;
        type = DataValue.Type.ARRAY;
      }

      // Attach it to the parent
      if (Objects.nonNull(parent) && parent != this) {
        DataModel child = parent.get(parentKey);
        JsonNode childNode = (JsonNode) ((DataValue) child.get()).getValue();
        if (node.getNodeType() == childNode.getNodeType()) {
          parent.replace(parentKey, new JsonModel(new DataValue(node, type, numberPragma), numberPragma));
        } else if (childNode.getNodeType() == JsonNodeType.ARRAY && node.getNodeType() == JsonNodeType.OBJECT) {
          // creating a copy and adding instead of removing and adding
          // because jsonnode doesnt support remove
          final ArrayNode copy = MAPPER.createArrayNode();
          ((ArrayNode) childNode).iterator().forEachRemaining(n -> copy.add((n == tempNode) ? node : n));
          parent.replace(parentKey,
              new JsonModel(new DataValue(copy, DataValue.Type.ARRAY, numberPragma), numberPragma));
        }
      }
    }
    return this;
  }

}
