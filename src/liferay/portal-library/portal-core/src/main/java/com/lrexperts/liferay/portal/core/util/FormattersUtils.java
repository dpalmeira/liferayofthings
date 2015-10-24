package com.lrexperts.liferay.portal.core.util;

import java.net.InetAddress;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The Class FormattersUtils.
 * 
 * @author Diego A. Palmeira
 */
public class FormattersUtils {

	/**
	 * List to string value, the returned string is the result of the concatenation of all objects in the list in its string representation through the toString() method.
	 *
	 * @param list the list
	 * @param separator the separator
	 * @return the string
	 */
	public static String listToString(List<?> list, String separator){
		StringBuilder sb = new StringBuilder("");
		
		if(list!=null){
			for(Object o: list){
				sb.append(o.toString()).append(separator);
			}
			if(sb.toString().length()>0){ //remove the delimiter separator
				sb.setLength(sb.length()-separator.length());
			}
		}
		return sb.toString();
	}
	
	/**
	 * Array to string value, the returned string is the result of the concatenation of all objects in the list in its string representation through the toString() method.
	 *
	 * @param array the array
	 * @param separator the separator
	 * @return the string
	 */
	public static String arrayToString(Object[] array, String separator){
		StringBuilder sb = new StringBuilder("");
		
		if(array!=null){
			for(Object o: array){
				if(o instanceof InetAddress){
					InetAddress i = (InetAddress)o;
					sb.append(i.getAddress()).append(separator);
				} else {
					sb.append(o.toString()).append(separator);
				}
			}
			if(sb.toString().length()>0){ //remove the delimiter separator
				sb.setLength(sb.length()-separator.length());
			}
		}
		return sb.toString();
	}
	
	/**
	 * Gets an array of strings resulted of split the given string with the given separator (regexp).
	 *
	 * @param str the str
	 * @param separator the separator
	 * @return the string
	 */
	public static String[] stringToArray(String str, String separator){
		String[] s = {};
		if(str!=null && str.length()>0){
			s = str.split(separator);
		}
		return s;
	}
	
	/**
	 * Gets a list of strings resulted of split the given string with the given separator (regexp).
	 *
	 * @param str the str
	 * @param separator the separator
	 * @return the string
	 */
	public static List<String> stringToList(String str, String separator){
		String[] s = stringToArray(str, separator);
		List<String> list = Arrays.asList(s);
		return list;
	}
	
	 /**
 	 * add doble quote to a tag words with space.
 	 *
 	 * @param tags the tags
 	 * @return the string[]
 	 */
	public static String[] addQuoteToTagsWithWhitespace(String[] tags){
	    	
	    	for (int i = 0; i < tags.length; i++) {
	    		String tag = tags[i];
	    		if( (tag.startsWith("\"")) && (tag.endsWith("\""))){
	    			break;
	    		}
	    		String espace =" ";
	    		if(tag.contains(espace)){
	    			tags[i] = "\""+tags[i]+"\"";	
	    		}	
			}
	    	return tags;
	    }
	
	/**
   	 * Convert millisecond to date.
   	 *
   	 * @param millisecond the millisecond
   	 * @return the date
   	 */
   	public static Date convertMillisecondToDate(long millisecond){
		   Calendar resultdate = Calendar.getInstance();
		   resultdate.setTimeInMillis(millisecond);
		   return resultdate.getTime();
	   }
   
	   /**
   	 * Convert from string to date.
   	 *
   	 * @param stringDate the string date
   	 * @return the date
   	 * @throws ParseException the parse exception
   	 */
   	public static Date convertFromStringToDate(String stringDate) throws ParseException{
		   	SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmss"); 
		   	Date resultdate=sdf.parse(stringDate);
		    return resultdate;
       }
		
}
