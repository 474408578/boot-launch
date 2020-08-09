package com.xschen.boot.launch.service;

import com.xschen.boot.launch.model.Article;
import org.springframework.stereotype.Service;

/**
 * @author xschen
 */

@Service
public interface ArticleService {
    String saveArticle(Article article);
}
