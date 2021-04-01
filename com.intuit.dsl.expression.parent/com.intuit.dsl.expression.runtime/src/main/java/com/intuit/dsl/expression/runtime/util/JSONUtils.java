package com.intuit.dsl.expression.runtime.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONObject;
import org.json.XML;

public class JSONUtils {

  private JSONUtils() {
  }

  public static final ObjectMapper MAPPER = new ObjectMapper().configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

  public static JsonNode getJSON(String path) throws IOException {
    return MAPPER.readValue(JSONUtils.class.getResourceAsStream(path), JsonNode.class);
  }

  /**
   * This function recursively iterates through the input JsonNode and returns a matching pattern dictated via the
   * Iterator node = { a: { b: 123 } }, recurse(b, node) => keep finding till "b" is found and return value of "b" i.e.
   * 123
   *
   * @param iterator String Iterator that acts as a matching filter
   * @param output JsonNode which holds all the data
   * @return String The value of the matching pattern
   */
  public static JsonNode recurse(Iterator<String> iterator, JsonNode output) {
    if (output != null && iterator.hasNext()) {
      String nextPath = iterator.next();
      try {
        return recurse(iterator, output.get(Integer.parseInt(nextPath)));
      } catch (NumberFormatException e) {
        return recurse(iterator, output.get(nextPath));
      }
    }
    return output;
  }

  /**
   * This function returns the value that is sought by the "path" inside a complicated nested JsonNode
   *
   * @param inputNode The JsonNode object that has all the data
   * @param path The path inside the inputNode JsonNode Object that you need the value for
   * @return String The value of the path inside the JSONNode Object
   */
  public static String getNodeValue(JsonNode inputNode, String path) {
    JsonNode node = recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), inputNode);
    return node.asText();
  }

  /**
   * This function returns the value that is sought by the "field" inside the JsonNode, if the field is not present, it
   * creates an empty node and then returns the newly created node.
   *
   * @param inputNode The JsonNode object
   * @param path The top-level field inside the inputNode JsonNode that you need the value for
   * @return ObjectNode The value of the field inside the JSONNode Object
   */
  public static JsonNode getOrCreate(String field, JsonNode inputNode) {
    if (!inputNode.has(field)) {
      ((ObjectNode) inputNode).replace(field, MAPPER.createObjectNode());
    }
    return inputNode.get(field);
  }

  public static JsonNode getJsonOrTextNode(String data) {
    if (EvaluatorUtils.isNumeric(data)) {
      return new DecimalNode(new BigDecimal(data));
    }
    try {
      ObjectReader reader = MAPPER.reader();
      JsonNode node = reader.readTree(data);
      if (node.isNumber() && !node.asText().equals(data)) {
        node = new TextNode(data);
      }
      return node;
    } catch (JsonProcessingException j) {
      return new TextNode(data);
    } catch (Exception e) {
      return new TextNode("");
    }
  }

  public static JsonNode getJSONFromString(String data) throws IOException {
    return MAPPER.reader().readTree(data);
  }

  public static JSONObject xmlToJSon(String xml) {
    return XML.toJSONObject(xml);
  }

  public static ArrayNode getArray(JsonNode json) {
    if (json == null) {
      return MAPPER.createArrayNode();
    }
    ArrayNode array = null;
    if (!json.isArray()) {
      array = MAPPER.createArrayNode();
      array.add(json);
    } else {
      array = (ArrayNode) json;
    }
    return array;
  }

  public static ObjectMapper getMapper() {
    return MAPPER;
  }

  public static JsonNode getErrorNode(String status, Integer statusCode, String message) {
    ObjectNode node = JSONUtils.MAPPER.createObjectNode();
    node.replace("status", new TextNode(status));
    node.replace("statusCode", new IntNode(statusCode));
    node.replace("message", new TextNode(message));
    ObjectNode errorNode = JSONUtils.MAPPER.createObjectNode();
    errorNode.replace("error", node);
    return errorNode;
  }

  public static boolean isNotNull(JsonNode node) {
    return !(node == null || node.getNodeType().equals(JsonNodeType.NULL) || node.isMissingNode());
  }


}