package com.lrexperts.liferay.portal.core.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * The Class DateUtils.
 * 
 * @author Diego A. Palmeira
 */
public class DateUtils{
	
	/** The log. */
	private static final Log log = LogFactory.getLog(DateUtils.class);
	
	/**
	 * Parses a string date to a Date object.
	 *
	 * @param dateText the date text
	 * @return Date, the parsed object
	 */
	public static Date stringToDate(String dateText){
		Date date = null;
		if (dateText!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM,yyyy", new Locale("es", "ES" ));
			try {
				date = simpleDateFormat.parse(dateText);
			} catch (ParseException e) {
				log.error("Problem parsing date", e);				
			}
		}
		return date;
	}
	
	/**
	 * Parses a string date to a Date object following the given pattern.
	 *
	 * @param dateText the date text
	 * @param pattern the pattern
	 * @return Date, the parsed object
	 */
	public static Date stringToDate(String dateText, String pattern){
		Date date = null;
		if (dateText!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("es", "ES" ));
			try {
				date = simpleDateFormat.parse(dateText);
			} catch (ParseException e) {
				log.error("Problem parsing date", e);
			}
		}
		return date;
	}
	
	/**
	 * Gets the string representation of a given date object.
	 *
	 * @param date the date
	 * @return String, the param date string representation
	 */
	public static String dateToString(Date date){
		String stringDate = "";
		if (date!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM, yyyy", new Locale("es", "ES" ));
			stringDate = simpleDateFormat.format(date);
			// For convert to uppercase the first letter. 
			StringBuilder stringBuilder = new StringBuilder();
			// Day.
			stringBuilder.append(stringDate.split(" ")[0] + " ");
			// Month first letter in uppercase.
			stringBuilder.append(stringDate.split(" ")[1].substring(0, 1).toUpperCase());
			// Other letters and comma.
			stringBuilder.append(stringDate.split(" ")[1].substring(1, stringDate.split(" ")[1].length()) + " ");
			// Year.
			stringBuilder.append(stringDate.split(" ")[2]);		
			
			stringDate = stringBuilder.toString();
		}
		return stringDate;
	}
	
	/**
	 * Gets the string representation of a given date object based on the format String.
	 *
	 * @param date the date
	 * @param format the format
	 * @return String, the param date string representation
	 */
	public static String dateToString(Date date, String format){
		String stringDate = "";
		if (date!=null){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format, new Locale("es", "ES" ));
			stringDate = simpleDateFormat.format(date);			
		}
		return stringDate;
	}
	
	/**
	 * gets a Date compared to todays date.
	 *
	 * @return Date todays date
	 */
	public static Date getTodayDate(){
		Calendar now = Calendar.getInstance();				
		int presentDayMillis = (
				(now.get(Calendar.HOUR_OF_DAY) * 3600 ) + 
				(now.get(Calendar.MINUTE) * 60) + 
				now.get(Calendar.SECOND)
		) * 1000;
		return new Date(System.currentTimeMillis() - presentDayMillis);	
	}
	
	/**
	 * gets a Date object with tomorrows date.
	 *
	 * @return Date tomorrows date
	 */
	public static Date getTomorrowDate(){
		Calendar now = Calendar.getInstance();				
		int oneDay = now.get(Calendar.HOUR_OF_DAY) + 24 * 3600 * 1000;
		return new Date(System.currentTimeMillis() + oneDay);	
	}
	
	/**
	 * Converts java.util.Date to java.sql.Date
	 *
	 * @param utilDate the util date
	 * @return java.sql.Date
	 */
	public static java.sql.Date toSqlDate(java.util.Date utilDate){
		return new java.sql.Date(utilDate.getTime());
	}
}