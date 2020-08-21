package com.xschen.boot.launch.service;

import com.xschen.boot.launch.dao.ArticleJDBCDAO;
import com.xschen.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xschen
 */

@Service
@Slf4j
public class ArtivleServiceImpl implements ArticleService {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;
    @Override
    public void saveArticle(Article article) {
        articleJDBCDAO.save(article);
    }

    @Override
    public void deleteArticle(Long id) {
        articleJDBCDAO.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleJDBCDAO.updateArticle(article);
    }

    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll();
    }
}
