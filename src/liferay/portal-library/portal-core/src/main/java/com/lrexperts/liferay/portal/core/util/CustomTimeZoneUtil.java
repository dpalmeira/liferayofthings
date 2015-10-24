package com.lrexperts.liferay.portal.core.util;

import com.liferay.portal.kernel.util.TimeZoneThreadLocal;

import java.util.TimeZone;

/**
 * The Class CustomTimeZoneUtil.
 * 
 * @author Diego A. Palmeira
 */
public class CustomTimeZoneUtil {
    public static TimeZone getTimeZone(){
        TimeZone timeZone = TimeZoneThreadLocal.getThemeDisplayTimeZone();
        if (timeZone==null){
            timeZone= TimeZoneThreadLocal.getDefaultTimeZone();
            if (timeZone == null){
                timeZone = TimeZone.getTimeZone("Europe/Madrid");
            }
        }
        return timeZone;
    }
}
