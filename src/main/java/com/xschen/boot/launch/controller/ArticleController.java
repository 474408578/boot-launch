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
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    //获取一篇Article，使用GET方法,根据id查询一篇文章
//    @RequestMapping(path = "/articles/{id}", method = RequestMethod.GET)
    @GetMapping("/articles/{id}")
    @ResponseBody
    public AjaxResponse getArticle(@PathVariable("id") Long id) {

        // 伪造数据，此处未使用数据库
//        List<Reader> readers = new ArrayList<>();
//        readers.add(new Reader("kobe", 21));
//        readers.add(new Reader("james", 20));
//
//        Article article = Article.builder()
//                .id(id)
//                .author("xschen")
//                .content("spring boot")
//                .title("t1")
//                .createTime(LocalDateTime.now())
//                .build();

        Article article = articleService.getArticle(id);
        log.info("article: " + article);

        return AjaxResponse.success(article);
    }

    // 增加一篇Article
//    @RequestMapping(path = "/articles", method = RequestMethod.POST)
    @PostMapping("/articles")
    public @ResponseBody AjaxResponse saveArticle(@RequestBody Article article) {
        log.info("saveArticle: " + article);
        articleService.saveArticle(article);
        return AjaxResponse.success();
    }

    // 更新文章
    @PutMapping("/articles")
    @ResponseBody
    public AjaxResponse updateArticle(@RequestBody Article article) {
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
}
