package com.intuit.dsl.expression.runtime.util;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

import util.TestUtils;

public class JsonUtilsTest {

  @Test
  public void getnOrCreateTest() {
    TestUtils.assertEquals("{}",
        JSONUtils.getOrCreate("any", JSONUtils.getMapper().createObjectNode()).toString());
    TestUtils.assertEquals("b",
        JSONUtils.getOrCreate("a", JSONUtils.getJsonOrTextNode("{'a':'b'}")).asText());
  }

  @Test
  public void getJsonOrTextNodeTest() {
    TestUtils.assertEquals("", JSONUtils.getJsonOrTextNode(null).asText());
    TestUtils.assertEquals("Abc", JSONUtils.getJsonOrTextNode("Abc").asText());
    TestUtils.assertEquals("{}", JSONUtils.getJsonOrTextNode("{}").toString());
    TestUtils.assertEquals(10, JSONUtils.getJsonOrTextNode("10").asInt());
    TestUtils.assertEquals(10.1, JSONUtils.getJsonOrTextNode("10.1").asDouble());
    TestUtils.assertEquals("1234 sjkf", JSONUtils.getJsonOrTextNode("1234 sjkf").asText());
    TestUtils.assertEquals("", JSONUtils.getJsonOrTextNode("").asText());
    TestUtils.assertEquals(JSONUtils.getJsonOrTextNode("{'a':'b'}"), "a", "b");
    TestUtils.assertEquals(11, JSONUtils.getJsonOrTextNode("00011").asInt());
  }

  @Test
  public void getArray() {
    TestUtils.assertNotNull(JSONUtils.getMapper());
    TestUtils.assertEquals("[]", JSONUtils.getArray(null).toString());
    TestUtils.assertEquals("[{}]",
        JSONUtils.getArray(JSONUtils.getMapper().createObjectNode()).toString());
    TestUtils.assertEquals("[]", JSONUtils.getArray(JSONUtils.MAPPER.createArrayNode()).toString());
  }

  @Test
  public void nullJsonNodeTest() {
    String test1 =
        "{\"IRS1040\":{\"Return\":{\"ReturnHeader\":{\"TaxYr\":\"2017\",\"IsImportFromPriorYearPdfPP\":null,\"IsYearOverYearPP\":null},\"ReturnData\":{\"PPPerson\":{\"TaxpayerFilerInfoPP\":{\"PersonFullNamePP\":{\"PersonFirstNm\":\"Ishani\",\"PersonLastNm\":null}}}}}}}";
    JsonNode testJson1 = null;
    try {
      testJson1 = JSONUtils.getJSONFromString(test1);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    TestUtils.assertNotNull(JSONUtils.getMapper());

    // valid node
    JsonNode goodNode = testJson1.findValue("TaxYr");
    TestUtils.assertEquals(true, JSONUtils.isNotNull(goodNode));

    // JsonNodeType.MISSING
    JsonNode node1 = testJson1.path("foo");
    TestUtils.assertEquals(false, JSONUtils.isNotNull(node1));

    // null
    JsonNode node2 = testJson1.findValue("foo");
    TestUtils.assertEquals(false, JSONUtils.isNotNull(node2));

    // JsonNodeType.NULL
    JsonNode node3 = testJson1.findValue("IsYearOverYearPP");
    TestUtils.assertEquals(false, JSONUtils.isNotNull(node3));
  }

}
