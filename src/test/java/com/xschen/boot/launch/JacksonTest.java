package com.xschen.boot.launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xschen.boot.launch.model.Article;
import com.xschen.boot.launch.model.Reader;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 */


public class JacksonTest {

    @Test
    void testJackson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        List<Reader> readers = new ArrayList<>();
        readers.add(new Reader("kobe", 21));
        readers.add(new Reader("james", 20));

        Article article = Article.builder()
                .id(2L)
                .author("zimug")
                .content("springboot 从青铜到王者")
                .createTime(LocalDateTime.now())
                .reader(readers)
                .title("t1").build();

        String jsonStr = mapper.writeValueAsString(article);

        System.out.println(jsonStr);

        Article article1 = mapper.readValue("{\"id\":1, \"content\":\"spring boot 从青铜到王者\",\"title\":\"t1\",\"createTime\":\"2020-06-05 09:18:43\",\"reader\":[{\"name\":\"kobe\",\"age\":21},{\"name\":\"james\",\"age\":20}],\"author\":\"zimug\"}",
                Article.class);

        System.out.println(article1);
    }
}
