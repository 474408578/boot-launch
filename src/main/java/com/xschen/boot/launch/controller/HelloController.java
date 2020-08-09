package com.xschen.boot.launch.controller;

import com.xschen.boot.launch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xschen
 */

@Slf4j
@RestController
public class HelloController {
    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    public String hello(String name) {
        ArticleVO articleVO = ArticleVO.builder()
                .id(1L)
                .author("xschen")
                .build();
        log.info("测试下" + articleVO);
        return "hello, world" + name;
    }
}
