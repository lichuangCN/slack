package site.muzhi.slack.util;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.util.ObjectUtil;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author lichuang
 * @date 2022/02/11
 */
public class LocalDateUtil {

    public final static Integer WEEK_DAY = 7;
    public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    public final static String DEFAULT_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public final static String DATE_PATTERN_STR1 = "yyyy-M-d";

    public static String format(LocalDateTime time) {
        assertNotNull(time);
        return LocalDateTimeUtil.format(time, DEFAULT_DATE_PATTERN);
    }

    public static LocalDateTime parse(String pattern, String time) {
        assertNotNull(pattern);
        assertNotNull(time);
        return LocalDateTimeUtil.parse(time, pattern);
    }

    /**
     * 当前日是当前周的第几天
     * return [1,7]
     */
    public static Integer dayOfWeek(LocalDateTime time) {
        assertNotNull(time);
        return time.getDayOfWeek().getValue();
    }

    /**
     * 两个日期之间的天数
     */
    public static Integer daysBetweenDate(LocalDateTime beginDate, LocalDateTime endDate) {
        assertNotNull(beginDate);
        assertNotNull(endDate);
        if (beginDate.isAfter(endDate)) {
            throw new RuntimeException("endDate must be later.");
        }
        long t1 = beginDate.toEpochSecond(ZoneOffset.ofHours(0));
        long day1 = t1 / (60 * 60 * 24);
        long t2 = endDate.toEpochSecond(ZoneOffset.ofHours(0));
        long day2 = t2 / (60 * 60 * 24);
        return (int) (day2 - day1);
    }

    private static void assertNotNull(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Param is not allowed null.");
        }
    }
}
