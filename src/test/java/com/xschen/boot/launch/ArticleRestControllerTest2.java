package com.xschen.boot.launch;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author xschen
 *
 * SpringBootTest：用来创建Spring的上下文ApplicationContext，保证测试在上下文环境里运行。
 * 单独使用SpringBootTest不会启动Servlet容器，所以不能使用@Resource和@Autowired等注解进行bean的注入
 */


@Slf4j
@AutoConfigureMockMvc // 表示mockMvc对象由Spring依赖注入构建，只负责使用就可以了
@SpringBootTest
public class ArticleRestControllerTest2 {

    @Resource
    private MockMvc mockMvc;

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
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders
                .request(HttpMethod.POST, "/rest/articles")
                .contentType("application/json")
                .content(article)
        );
        resultActions.andReturn().getResponse().setCharacterEncoding("utf-8");
        MvcResult mvcResult = resultActions
                .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();

        log.info(mvcResult.getResponse().getContentAsString());

    }
}
