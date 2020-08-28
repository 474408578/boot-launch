package com.xschen.boot.launch.dao.testdb;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author xschen
 */


public interface ArticleRepository extends JpaRepository<Article, Long> {

    Article findByAuthor(String author);
}
