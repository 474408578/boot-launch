package com.xschen.boot.launch.service;


import com.xschen.boot.launch.model.ArticleVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xschen
 */

@Service
public interface ArticleService {
    void saveArticle(ArticleVO article);

    void deleteArtice(Long id);

    void updateArticle(ArticleVO article);

    ArticleVO getArticle(Long id);

    List<ArticleVO> getAll();
}
