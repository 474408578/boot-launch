package com.xschen.boot.launch.dao;

import com.xschen.boot.launch.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByAuthor(String zimug);
}
