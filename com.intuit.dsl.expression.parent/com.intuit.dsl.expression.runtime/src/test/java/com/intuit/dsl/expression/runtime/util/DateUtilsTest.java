package com.intuit.dsl.expression.runtime.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import util.TestUtils;

public class DateUtilsTest {
	SimpleDateFormat selectedParser = new SimpleDateFormat("MM/dd/yyyy");

	@Test
	public void currentDateShouldBeStringTest() {
		String todayDate = DateUtils.currentDate(null);
		TestUtils.assertEquals(true, todayDate.getClass().getName() == "java.lang.String");
	}

	@Test
	public void currentDateShouldMatchTest() {
		String todayDate = DateUtils.currentDate(null);
		TestUtils.assertEquals(selectedParser.format(new Date()), todayDate);
	}

	@Test
	public void dayDifferenceShouldBe0Test() {
		String from = "10/10/2012";
		String to = "10/10/2012";
		String dateParser = "MM/dd/yyyy";
		Long expected = (long) 0;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(expected, difference);
	}

	@Test
	public void dayDifferenceShouldBePositiveNumberTest() {
		String from = "10/10/2012";
		String to = "10/15/2012";
		String dateParser = "MM/dd/yyyy";
		Long expected = (long) 5;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(expected, difference);
	}

	@Test
	public void dayDifferenceShouldBeNegativeNumberTest() {
		String from = "10/15/2012";
		String to = "10/10/2012";
		String dateParser = "MM/dd/yyyy";
		Long expected = (long) -5;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(expected, difference);
	}

	@Test
	public void dayDifferenceShouldReturnMaxValueWhenExceptionTest() {
		String from = "10/15/2012";
		String to = "10/10/2062";
		String dateParser = "YY/XX/ZZZZ";
		Long expected = (long) Long.MAX_VALUE;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(expected, difference);
	}

	@Test
	public void dayDifferenceCanExceed365Test() {
		String from = "10/15/2012";
		String to = "10/10/2022";
		String dateParser = "MM/dd/yyyy";
		Long expected = (long) 365;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(true, difference > expected);
	}

	@Test
	public void dayDifferenceDifferentFormatterTest() {
		String from = "20121005";
		String to = "20121015";
		String dateParser = "yyyyMMdd";
		Long expected = (long) 10;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(expected, difference);
	}

	@Test
	public void dayDifferenceDifferentFormatter2Test() {
		String from = "2012-10-11";
		String to = "2012-10-17";
		String dateParser = "yyyy-MM-dd";
		Long expected = (long) 6;
		Long difference = DateUtils.dayDifference(from, to, dateParser);
		TestUtils.assertEquals(expected, difference);
	}

	@Test
	public void currentDateFormatterTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		String expected = sdf.format(new Date());
		String actual = DateUtils.currentDate("yyyy-MM-dd'T'HH:mm:ssXXX");
		TestUtils.assertEquals(expected, actual);
	}
}
