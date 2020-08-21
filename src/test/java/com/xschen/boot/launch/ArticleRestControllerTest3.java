package com.xschen.boot.launch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xschen.boot.launch.model.Article;
import com.xschen.boot.launch.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author xschen
 */

@Slf4j
@AutoConfigureMockMvc
//@SpringBootTest // 加载完整的应用程序，并且注入所有可能的bean，比较重量级，因此速度会很慢
@WebMvcTest // 轻量级的测试，主要用于controller层的测试，只覆盖应用程序的controller层，速度相对较快
public class ArticleRestControllerTest3 {

    @Resource
    private MockMvc mockMvc;

    // mock一个假的service，把接口校验完成
    @MockBean
    private ArticleService articleService;

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n" +
                "    \"id\": 1,\n" +
                "    \"author\": \"zimug\",\n" +
                "    \"title\": \"手摸手教你开发spring boot\",\n" +
                "    \"content\": \"c\",\n" +
                "    \"createTime\": \"2017-07-16 05:23:34\",\n" +
                "    \"reader\":[{\"name\":\"zimug\",\"age\":18},{\"name\":\"kobe\",\"age\":37}]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Article articleObj = objectMapper.readValue(article, Article.class);


        /**
         * 打桩，告诉应用程序，当调用articleService.saveArticle(articleObj)时，不是真的调用这个方法，
         * 直接返回一个结果("ok")就行了。
         */
//        when(articleService.saveArticle(articleObj)).thenReturn("ok");

        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                .request(HttpMethod.POST, "/rest/articles")
                .contentType("application/json;charset=utf-8")
                .content(article)
        );

        resultActions.andReturn().getResponse().setCharacterEncoding("utf-8");
        MvcResult mvcResult = resultActions
                .andExpect(MockMvcResultMatchers.jsonPath("$.data").value("ok"))
                .andDo(print())
                .andReturn();

        log.info(mvcResult.getResponse().getContentAsString());


    }
}
