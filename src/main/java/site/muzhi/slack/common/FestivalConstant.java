package site.muzhi.slack.common;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lichuang
 * @date 2022/02/14
 */
@Getter
public class FestivalConstant {
    private static Map<String, String> qingMingMap;

    static {
        initQingMing();
    }

    private static void initQingMing() {
        qingMingMap = new HashMap<>(16);
        qingMingMap.put("2022", "2022-04-05");
        qingMingMap.put("2023", "2023-04-05");
        qingMingMap.put("2024", "2024-04-04");
        qingMingMap.put("2025", "2025-04-04");
        qingMingMap.put("2026", "2026-04-05");
        qingMingMap.put("2027", "2027-04-05");
        qingMingMap.put("2028", "2027-04-04");
        qingMingMap.put("2029", "2027-04-04");
        qingMingMap.put("2030", "2027-04-05");
    }

    public static String getQingMing(String year) {
        if (qingMingMap == null) {
            initQingMing();
        }
        String date = qingMingMap.get(year);
        return date;
    }

}
