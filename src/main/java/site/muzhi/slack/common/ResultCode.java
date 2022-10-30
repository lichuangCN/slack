package site.muzhi.slack.common;

import lombok.Getter;

/**
 * @author lichuang
 * @date 2022/02/11
 */
@Getter
public enum ResultCode {
    SUCCESS(1000, "成功"),
    FAIL(2000, "服务器错误"),
    ;

    private Integer code;

    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
