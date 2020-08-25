package com.xschen.boot.launch;

import com.xschen.boot.launch.dao.ArticleRepository;
import com.xschen.boot.launch.model.Article;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author xschen
 */

@SpringBootTest

public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void userTest() {
        Article article = articleRepository.findByAuthor("zimug");
        System.out.println(article);
    }
}
