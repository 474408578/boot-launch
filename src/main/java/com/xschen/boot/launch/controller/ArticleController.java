package com.xschen.boot.launch.controller;

import com.xschen.boot.launch.model.AjaxResponse;
import com.xschen.boot.launch.model.Article;
import com.xschen.boot.launch.model.ArticleVO;
import com.xschen.boot.launch.model.Reader;
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
@Controller
@RequestMapping("/rest")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    //获取一篇Article，使用GET方法,根据id查询一篇文章
    @GetMapping("/articles/{id}")
    @ResponseBody
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        ArticleVO article = articleService.getArticle(id);
        log.info("article: " + article);

        return AjaxResponse.success(article);
    }

    // 增加一篇Article
    @PostMapping("/articles")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody ArticleVO article) {
        log.info("saveArticle: " + article);
        articleService.saveArticle(article);
        return AjaxResponse.success();
    }

    // 更新文章
    @PutMapping("/articles")
    @ResponseBody
    public AjaxResponse updateArticle(@RequestBody ArticleVO article) {
        articleService.updateArticle(article);
        log.info("updateArticle: " + article);
        return AjaxResponse.success();
    }

    @DeleteMapping("/articles/{id}")
    @ResponseBody
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        log.info("deleteArticle: " + id);
        return AjaxResponse.success();
    }

    @GetMapping("/articles")
    @ResponseBody
    public AjaxResponse getArticle() {
        List<ArticleVO> articles = articleService.getAll();
        log.info("articles: " + articles);
        return AjaxResponse.success(articles);
    }
}
