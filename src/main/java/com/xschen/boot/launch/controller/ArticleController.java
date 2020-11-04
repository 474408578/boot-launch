package com.xschen.boot.launch.controller;

import com.xschen.boot.launch.AjaxResponse;
import com.xschen.boot.launch.model.ArticleVO;
import com.xschen.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xschen
 */

@Slf4j
//@RestController
@Controller
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @GetMapping("/articles/{id}")
    public @ResponseBody AjaxResponse getArticle(@PathVariable("id") Long id) {
        ArticleVO article = articleService.getArticle(id);
        log.info("article: " +article);
        return AjaxResponse.success(article);
    }

    @GetMapping("/articles")
    public @ResponseBody AjaxResponse getArticle() {
        List<ArticleVO> articles = articleService.getAll();
        log.info("articles: " + articles);
        return AjaxResponse.success(articles);
    }

    @PostMapping("/articles")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        articleService.saveArticle(article);
        log.info("saveArticle: " + article);
        return AjaxResponse.success();
    }

    @PutMapping("/articles")
    public @ResponseBody AjaxResponse updateArticle(@RequestBody ArticleVO article) {
        articleService.updateArticle(article);
        log.info("updateArticle:" + article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/articles/{id}")
    public @ResponseBody AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        log.info("deleteArticle:" + id);
        return AjaxResponse.success();
    }

}
