package com.xschen.boot.launch.service;

import com.xschen.boot.launch.model.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xschen
 */

@Service
public interface ArticleService {
    void saveArticle(Article article);

    void deleteArticle(Long id);

    void updateArticle(Article article);

    Article getArticle(Long id);

    List<Article> getAll();
}
