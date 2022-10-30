package site.muzhi.slack.business;

import site.muzhi.slack.dto.DateRepDTO;

/**
 * @author lichuang
 * @date 2022/02/11
 */
public interface IndexBusinessService {

    /**
     * 计算天数
     */
    DateRepDTO compute();
}
