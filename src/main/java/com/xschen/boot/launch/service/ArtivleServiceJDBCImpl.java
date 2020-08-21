package com.xschen.boot.launch.service;

import com.xschen.boot.launch.dao.ArticleJDBCDAO;
import com.xschen.boot.launch.model.Article;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xschen
 */

@Service
@Slf4j
public class ArtivleServiceJDBCImpl implements ArticleService {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Override
    @Transactional
    public void saveArticle(Article article) {
//        articleJDBCDAO.save(article);
        articleJDBCDAO.save(article, primaryJdbcTemplate);
        articleJDBCDAO.save(article, secondaryJdbcTemplate);
        int a = 2 / 0;
    }

    @Override
    public void deleteArticle(Long id) {
//        articleJDBCDAO.deleteById(id);
        articleJDBCDAO.deleteById(id, null);
    }

    @Override
    @Transactional
    public void updateArticle(Article article) {
        if(article.getId() == null){
            //article.id是必传参数，因为通常根据id去修改数据
            //TODO 抛出一个自定义的异常
        }
//        articleJDBCDAO.updateArticle(article);
        articleJDBCDAO.updateArticle(article, null);
    }


    @Override
    public Article getArticle(Long id) {
        return articleJDBCDAO.findById(id, null);
    }

    @Override
    public List<Article> getAll() {
        return articleJDBCDAO.findAll(null);
    }
}
