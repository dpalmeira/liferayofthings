package com.lrexperts.liferay.liferayofthings.portlet.common.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Diego A. Palmeira
 */
public class DataUtil {

	public static final Date[] getDatesForSelectedPeriod(int year) {
		Date[] dates = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, 0, 1, 0, 0);
		dates[0] = calendar.getTime();
		calendar.set(year, 11, 31, 23, 59);
		dates[1] = calendar.getTime();
		return dates;
	}

}
