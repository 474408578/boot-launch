package com.xschen.boot.launch.service;


import com.xschen.boot.launch.model.ArticleVO;

import java.util.List;

/**
 * @author xschen
 */


public interface ArticleService {
    void saveArticle(ArticleVO article);

    void deleteArticle(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
