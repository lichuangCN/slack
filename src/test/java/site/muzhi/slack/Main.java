package site.muzhi.slack;

import site.muzhi.slack.util.LunarSolarConverter;

/**
 * @author lichuang
 * @date 2022/02/11
 */
public class Main {
    public static void main(String[] args) {
        LunarSolarConverter.Solar solar = LunarSolarConverter.LunarToSolar(2023, 1, 1);
        System.out.println(solar);
    }
}
