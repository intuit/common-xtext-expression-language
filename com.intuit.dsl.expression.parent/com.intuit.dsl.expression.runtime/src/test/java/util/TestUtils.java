package util;

import java.util.Arrays;
import org.junit.Assert;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.NullNode;
import com.intuit.dsl.expression.runtime.util.JSONUtils;

public class TestUtils {

  private static final ObjectMapper MAPPER = new ObjectMapper();

  public static ObjectMapper mapper() {
    return MAPPER;
  }

  public static void assertEquals(JsonNode output, String path, long i) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertEquals(i, node.asLong());
  }
  
  public static void assertEquals(JsonNode output, String path, double i) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertEquals(i, node.asDouble());
  }

  public static void assertEquals(JsonNode output, String path, String string) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertEquals(string, node.asText());
  }

  public static void assertEquals(JsonNode output, String path, Boolean bool) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertEquals(bool, node.asBoolean());
  }

  public static void assertNull(JsonNode output, String path) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertEquals("null", node.asText());
  }
  
  public static void assertSize(JsonNode output, String path, int size) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertEquals(size, node.size());
  }

  public static void assertEquals(Object expected, Object actual) {
    // Generic assertEquals for all objects
    Assert.assertEquals(expected, actual);
  }

  public static void assertNull(Object o) {
    Assert.assertNull(o);
  }

  public static void assertNotNull(Object o) {
    Assert.assertNotNull(o);
  }

  public static void assertNotNull(JsonNode output, String path) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    assertNotNull(node.asText());
  }

  public static void assertEquals(JsonNode output, String path, NullNode instance) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    Assert.assertEquals(node.asText(), instance.asText());
  }

  public static boolean containsKey(JsonNode output, String path) {
    JsonNode node = JSONUtils
        .recurse(Arrays.asList(path.replace("]", "").split("\\.|\\[")).iterator(), output);
    return node != null;
  }


}
