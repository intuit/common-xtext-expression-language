package com.intuit.dsl.expression.runtime.util;

import org.junit.Test;

import util.TestUtils;

public class EvaluatorUtilsTest {

	@Test
	public void compareToTest() {
		TestUtils.assertEquals(-1, EvaluatorUtils.compareTo("abc", "bcd"));
		TestUtils.assertEquals(1, EvaluatorUtils.compareTo("bcdef", "abcdef"));
		TestUtils.assertEquals(-1, EvaluatorUtils.compareTo("123", "231"));
		TestUtils.assertEquals(1, EvaluatorUtils.compareTo("344", "123"));
		TestUtils.assertEquals(-1, EvaluatorUtils.compareTo("-344", "-123"));
		TestUtils.assertEquals(-1, EvaluatorUtils.compareTo("-344", "1234"));
		TestUtils.assertEquals(1, EvaluatorUtils.compareTo("1234", "-344"));
		TestUtils.assertEquals(0, EvaluatorUtils.compareTo("", ""));
		TestUtils.assertEquals(0, EvaluatorUtils.compareTo(null, null));
		TestUtils.assertEquals(1, EvaluatorUtils.compareTo("", null));
		TestUtils.assertEquals(-1, EvaluatorUtils.compareTo(null, ""));
	}

	@Test
	public void getNumberNodeTest() {
		TestUtils.assertEquals("1111111111111111111111111111111111111111111111111111111111111111111111111111111111",
				EvaluatorUtils
						.getNumberNode(
								"1111111111111111111111111111111111111111111111111111111111111111111111111111111111")
						.asText());
		TestUtils.assertNull(EvaluatorUtils.getNumberNode("abc"));
		TestUtils.assertNull(EvaluatorUtils.getNumberNode("+25.00"));
		TestUtils.assertNull(EvaluatorUtils.getNumberNode("+25.00.00"));
		TestUtils.assertEquals("25", EvaluatorUtils.getNumberNode("25.00").asText());
		TestUtils.assertEquals("-25", EvaluatorUtils.getNumberNode("-25.00").asText());
		TestUtils.assertEquals("25", EvaluatorUtils.getNumberNode("25").asText());
		TestUtils.assertEquals("25.12", EvaluatorUtils.getNumberNode("25.12").asText());
		TestUtils.assertEquals("-25.12", EvaluatorUtils.getNumberNode("-25.12").asText());
		TestUtils.assertEquals("0", EvaluatorUtils.getNumberNode("0.00").asText());
		TestUtils.assertEquals("-0.12", EvaluatorUtils.getNumberNode("-0.12").asText());
		TestUtils.assertEquals("120880", EvaluatorUtils.getNumberNode("120880.").asText());
		TestUtils.assertEquals("0", EvaluatorUtils.getNumberNode("0.").asText());
		TestUtils.assertNull(EvaluatorUtils.getNumberNode(null));
	}

}
