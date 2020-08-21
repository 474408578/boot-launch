package com.xschen.boot.launch;

import com.xschen.boot.launch.dao.ArticleJDBCDAO;
import com.xschen.boot.launch.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author xschen
 */

@SpringBootTest
public class SpringJdbcTest {
    @Resource
    private ArticleJDBCDAO articleJDBCDAO;

    @Resource
    private JdbcTemplate primaryJdbcTemplate;

    @Resource
    private JdbcTemplate secondaryJdbcTemplate;


    @Test
    public void testJdbc() {
        articleJDBCDAO.save(Article.builder()
        .author("zimuge")
        .title("primaryJdbcTemplate")
        .content("ceshi")
        .createTime(LocalDateTime.now())
        .build(), primaryJdbcTemplate);
    }

}
