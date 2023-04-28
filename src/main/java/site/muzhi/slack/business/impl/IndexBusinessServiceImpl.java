package site.muzhi.slack.business.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import site.muzhi.slack.business.IndexBusinessService;
import site.muzhi.slack.common.FestivalConstant;
import site.muzhi.slack.common.WeekDayEnum;
import site.muzhi.slack.dto.DateRepDTO;
import site.muzhi.slack.util.LocalDateUtil;
import site.muzhi.slack.util.LunarSolarConverter;

import java.time.LocalDateTime;

/**
 * @author lichuang
 * @date 2022/02/11
 */
@Slf4j
@Service
public class IndexBusinessServiceImpl implements IndexBusinessService {

    @Override
    public DateRepDTO compute() {

        DateRepDTO result = new DateRepDTO();
        // 1.当前日
        LocalDateTime today = LocalDateTime.now();
        result.setDate(LocalDateUtil.format(today));
        // 2.周几
        Integer weekday = LocalDateUtil.dayOfWeek(today);
        result.setWeekday(WeekDayEnum.desc(weekday));
        // 3.距离周末
        result.setToWeekendDay(LocalDateUtil.WEEK_DAY - weekday - 1);
        // 4.距离元旦
        result.setToNewYearDay(toNewYearDay(today));
        // 5.距离春节
        result.setToChineseNewYearDay(toChineseNewYearDay(today));
        // 6.距离清明
        result.setToQingMingDay(toQingMingDay(today));
        // 7.距离劳动节
        result.setToWorkerDay(toWorkerDay(today));
        // 8.距离端午节
        result.setToDragonBoatFestivalDay(toDragonBoatFestivalDay(today));
        // 9.距离中秋节
        result.setToMidAutumnFestivalDay(toMidAutumnFestivalDay(today));
        // 10.距离国庆节
        result.setToNationalDay(toNationalDay(today));
        log.info("compute: {}", JSONObject.toJSONString(result));
        return result;
    }

    /**
     * 距离五一
     */
    private Integer toNationalDay(LocalDateTime today) {
        int year = today.getYear();
        StringBuilder builder = new StringBuilder();
        String date = builder.append(year).append("-10-01").toString();
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        // 下一年
        if (today.isAfter(target)) {
            builder = new StringBuilder();
            date = builder.append(year + 1).append("-10-01").toString();
            target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        }
        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        return days;
    }

    /**
     * 距离中秋节
     */
    private Integer toMidAutumnFestivalDay(LocalDateTime today) {
        int year = today.getYear();
        LunarSolarConverter.Solar solar = LunarSolarConverter.LunarToSolar(year, 8, 15);
        StringBuilder builder = new StringBuilder();
        // YYYY-M-d
        String date = builder.append(solar.getSolarYear()).append("-")
                .append(solar.getSolarMonth()).append("-")
                .append(solar.getSolarDay()).toString();
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DATE_PATTERN_STR1, date);
        // 下一年
        if (today.isAfter(target)) {
            builder = new StringBuilder();
            solar = LunarSolarConverter.LunarToSolar(year + 1, 8, 15);
            date = builder.append(solar.getSolarYear()).append("-")
                    .append(solar.getSolarMonth()).append("-")
                    .append(solar.getSolarDay()).toString();
            target = LocalDateUtil.parse(LocalDateUtil.DATE_PATTERN_STR1, date);
        }

        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        return days;
    }

    /**
     * 距离端午
     */
    private Integer toDragonBoatFestivalDay(LocalDateTime today) {
        int year = today.getYear();
        LunarSolarConverter.Solar solar = LunarSolarConverter.LunarToSolar(year, 5, 5);
        StringBuilder builder = new StringBuilder();
        // YYYY-M-d
        String date = builder.append(solar.getSolarYear()).append("-")
                .append(solar.getSolarMonth()).append("-")
                .append(solar.getSolarDay()).toString();
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DATE_PATTERN_STR1, date);
        // 下一年
        if (today.isAfter(target)) {
            builder = new StringBuilder();
            solar = LunarSolarConverter.LunarToSolar(year + 1, 5, 5);
            date = builder.append(solar.getSolarYear()).append("-")
                    .append(solar.getSolarMonth()).append("-")
                    .append(solar.getSolarDay()).toString();
            target = LocalDateUtil.parse(LocalDateUtil.DATE_PATTERN_STR1, date);
        }

        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        return days;
    }

    /**
     * 距离五一
     */
    private Integer toWorkerDay(LocalDateTime today) {
        int year = today.getYear();
        StringBuilder builder = new StringBuilder();
        String date = builder.append(year).append("-05-01").toString();
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        // 下一年
        if (today.isAfter(target)) {
            builder = new StringBuilder();
            date = builder.append(year + 1).append("-05-01").toString();
            target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        }
        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        return days;
    }

    /**
     * 距离清明
     */
    private Integer toQingMingDay(LocalDateTime today) {
        int year = today.getYear();
        String date = FestivalConstant.getQingMing(String.valueOf(year));
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        // 下一年
        if (today.isAfter(target)) {
            date = FestivalConstant.getQingMing(String.valueOf(year + 1));
            target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        }
        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        return days;
    }

    /**
     * 距离春节
     */
    private Integer toChineseNewYearDay(LocalDateTime today) {
        int year = today.getYear();
        LunarSolarConverter.Solar solar = LunarSolarConverter.LunarToSolar(year, 1, 1);
        StringBuilder builder = new StringBuilder();
        // YYYY-M-d
        String date = builder.append(solar.getSolarYear()).append("-")
                .append(solar.getSolarMonth()).append("-")
                .append(solar.getSolarDay()).toString();
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DATE_PATTERN_STR1, date);
        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        if (days < 0) {
            solar = LunarSolarConverter.LunarToSolar(year + 1, 1, 1);
            builder = new StringBuilder();
            // YYYY-M-d
            date = builder.append(solar.getSolarYear()).append("-")
                    .append(solar.getSolarMonth()).append("-")
                    .append(solar.getSolarDay()).toString();
            target = LocalDateUtil.parse(LocalDateUtil.DATE_PATTERN_STR1, date);
            days = LocalDateUtil.daysBetweenDate(today, target);
        }
        return days;
    }

    /**
     * 距离元旦
     */
    private Integer toNewYearDay(LocalDateTime today) {
        int year = today.getYear();
        String date = new StringBuilder().append(year + 1).append("-01-01").toString();
        LocalDateTime target = LocalDateUtil.parse(LocalDateUtil.DEFAULT_DATE_PATTERN, date);
        Integer days = LocalDateUtil.daysBetweenDate(today, target);
        return days;
    }
}
