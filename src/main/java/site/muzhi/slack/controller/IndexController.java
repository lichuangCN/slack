package site.muzhi.slack.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import site.muzhi.slack.business.IndexBusinessService;
import site.muzhi.slack.common.Result;
import site.muzhi.slack.dto.DateRepDTO;

/**
 * @author lichuang
 * @date 2022/02/11
 */
@RestController
@Slf4j
public class IndexController {

    @Autowired
    private IndexBusinessService indexBusinessService;

    @GetMapping("/index/item")
    public Result<DateRepDTO> indexItem() {
        DateRepDTO data = indexBusinessService.compute();
        return Result.ok(data);
    }
}
