package com.xschen.boot.launch.controller;

import com.xschen.boot.launch.model.AjaxResponse;
import com.xschen.boot.launch.model.Article;
import com.xschen.boot.launch.model.ArticleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * @author xschen
 */

@Slf4j
@RestController
@RequestMapping("/rest")
public class ArticleController {

    //获取一篇Article，使用GET方法,根据id查询一篇文章
    @RequestMapping(path = "/article/{id}", method = RequestMethod.GET)
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        // 伪造数据，此处未使用数据库
        Article article = Article.builder()
                .id(id)
                .author("xschen")
                .content("spring boot")
                .title("t1")
                .createTime(LocalDateTime.now())
                .build();
        log.info("article: " + article);

        return AjaxResponse.success(article);
    }

    // 增加一篇Article
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public AjaxResponse saveArticle(@RequestParam Long id,
                                    @RequestParam String content,
                                    @RequestParam String title,
                                    @RequestParam String author) {
        Article article = Article.builder()
                .id(id)
                .author(author)
                .content(content)
                .title(title)
                .createTime(LocalDateTime.now())
                .build();

        log.info("saveArticle: " + article);
        return AjaxResponse.success();
    }

    // 更新文章
    @RequestMapping(path = "/article/{id}", method = RequestMethod.PUT)
    public AjaxResponse updateArticle(@PathVariable Long id,
                                      @RequestParam String content,
                                      @RequestParam String title,
                                      @RequestParam String author) {
        Article article = Article.builder()
                .id(id)
                .author(author)
                .content(content)
                .title(title)
                .createTime(LocalDateTime.now())
                .build();

        log.info("saveArticle: " + article);
        return AjaxResponse.success();
    }

    @RequestMapping(path = "/article/{id}", method = RequestMethod.DELETE)
    public AjaxResponse deleteArticle(@PathVariable Long id,
                                      @RequestParam String content,
                                      @RequestParam String title,
                                      @RequestParam String author) {
        Article article = Article.builder()
                .id(id)
                .author(author)
                .content(content)
                .title(title)
                .createTime(LocalDateTime.now())
                .build();

        log.info("saveArticle: " + article);
        return AjaxResponse.success();
    }
}
