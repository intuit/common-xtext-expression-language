package com.intuit.dsl.expression.runtime.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings("all")
public class DateUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(DateUtils.class);

	/**
	 * This function calculates the difference in days from Today's date to the Date
	 * string sent as an arg
	 * 
	 * @param to String Target Date to calculate difference till
	 * @param from String Source Data to alculate difference from
	 * @param dateParser String Date parser
	 * @return Long Difference in Days
	 */
	public static long dayDifference(final String from, final String to, final String dateParser) {
		final SimpleDateFormat selectedParser = new SimpleDateFormat(dateParser);
		try {
			long fromDate = selectedParser.parse(from).getTime();
			long toDate = selectedParser.parse(to).getTime();
			return TimeUnit.DAYS.convert((toDate - fromDate), TimeUnit.MILLISECONDS);
		} catch (final Exception e) {
			LOGGER.error("Exception caught in dayDifference: " + e.getMessage());
			return Long.MAX_VALUE;
		}
	}

	/**
	 * This function returns today's date as a String in the format MM/dd/yyyy
	 * 
	 * @param format String Date 
	 * @return String Today's date in MM/dd/yyyy
	 */
	public static String currentDate(final String format) {
		String toFormat = (format == null) ? "MM/dd/yyyy" : StringUtils.remove(format, "\"");
		final SimpleDateFormat selectedParser = new SimpleDateFormat(toFormat);
		try {
			Date _date = new Date();
			return selectedParser.format(_date);
		} catch (final Exception e) {
			LOGGER.error("Exception caught in dayDifference: " + e.getMessage());
			return null;
		}
	}
}
