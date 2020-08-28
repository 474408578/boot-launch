package com.xschen.boot.launch;

import com.xschen.boot.launch.dao.testdb.Article;
import com.xschen.boot.launch.dao.testdb.ArticleRepository;
import com.xschen.boot.launch.dao.testdb2.Message;
import com.xschen.boot.launch.dao.testdb2.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author xschen
 */


@SpringBootTest
public class JPAKeyWordTest {

    @Resource
    private ArticleRepository articleRepository;

    @Resource
    private MessageRepository messageRepository;

    @Test
    public void jpaRespositoryTest() {
        Article article = articleRepository.findByAuthor("xschen");
        System.out.println(article);
    }

    @Test
    public void jpaTest() {
        Article article = Article.builder()
                .author("zimug")
                .content("springboot")
                .createTime(new Date())
                .title("t1")
                .build();

        Message message = Message.builder()
                .name("zimug")
                .content("ok")
                .build();

        articleRepository.save(article);
        messageRepository.save(message);
    }

}
