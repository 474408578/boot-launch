package com.xschen.boot.launch.dao;

import com.xschen.boot.launch.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xschen
 *
 *
 */

@Repository
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate primaryJdbcTemplate;


    // 保存文章
    public void save(Article article, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("INSERT INTO article(author, title, content, create_time) values(?, ?, ?, ?)",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime());
    }

    // 删除文章
    public void deleteById(Long id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        // jdbcTemplate.update适合阈insert、update、delete操作
        jdbcTemplate.update("DELETE FROM article WHERE id = ?", id);
    }

    // 更新文章
    public void updateArticle(Article article, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        jdbcTemplate.update("UPDATE article SET author = ?, title = ?, content = ?, create_time = ? WHERE id = ?",
                article.getAuthor(),
                article.getTitle(),
                article.getContent(),
                article.getCreateTime(),
                article.getId());
    }

    // 根据id查找文章
    public Article findById(Long id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        // jdbcTemplate.queryForObject用于查询单条记录返回结果
        // BeanPropertyRowMapper可以将数据库字段的值向Article对象映射，满足驼峰标识也可以自动映射。
        return (Article) jdbcTemplate.queryForObject("SELECT * FROM article WHERE id = ?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Article.class));
    }

    // 查询所有
    public List<Article> findAll(JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = primaryJdbcTemplate;
        }
        // jdbcTemplate.query用于查询结果列表
        return (List<Article>) jdbcTemplate.query("SELECT * FROM article", new BeanPropertyRowMapper<>(Article.class));
    }
}
