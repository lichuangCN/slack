package site.muzhi.slack.common;

import lombok.Getter;

/**
 * @author lichuang
 * @date 2022/02/11
 */
@Getter
public enum WeekDayEnum {
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期天"),
    ;
    private Integer day;
    private String desc;

    WeekDayEnum(Integer day, String desc) {
        this.day = day;
        this.desc = desc;
    }

    public static String desc(Integer day) {
        for (WeekDayEnum value : values()) {
            if (value.getDay().equals(day)) {
                return value.getDesc();
            }
        }
        return "";
    }
}
