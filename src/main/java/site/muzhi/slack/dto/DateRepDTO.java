package site.muzhi.slack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lichuang
 * @date 2022/02/11
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DateRepDTO {
    /**
     * 今天是 2021-12-29 星期三
     * 你好，摸鱼人，工作再累，一定不要忘记摸鱼哦 ! 有事没事起身去茶水间去廊道去天台走走，别老在工位上坐着。 多喝点水，钱是老板的，但命是自己的 !
     * 距离 周末 放假还有 2 天
     * 距离 元旦 放假还有 3 天
     * 距离 过年 放假还有 34 天
     * 距离 清明节 放假还有 97 天
     * 距离 劳动节 放假还有 123 天
     * 距离 端午节 放假还有 156 天
     * 距离 中秋节 放假还有 255 天
     * 距离 国庆节 放假还有 276 天
     */
    private String date;
    private String weekday;
    private Integer toWeekendDay;
    private Integer toNewYearDay;
    private Integer toChineseNewYearDay;
    private Integer toQingMingDay;
    private Integer toWorkerDay;
    private Integer toDragonBoatFestivalDay;
    private Integer toMidAutumnFestivalDay;
    private Integer toNationalDay;
}
