package com.xschen.boot.launch;

import com.xschen.boot.launch.controller.ArticleController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @author xschen
 */

@Slf4j
public class ArticleRestControllerTest {

    //mock对象, 模拟发送http请求
    private static MockMvc mockMvc;

    //在所有测试方法执行之前进行mock对象初始化
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleController()).build();
    }

    //测试方法
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
        // 模拟http请求
        MvcResult result = mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/rest/articles")
                        .contentType("application/json;charset=utf-8")
                        .content(article)
        )
                // 如果不满足执行结果就会失败
                .andExpect(MockMvcResultMatchers.status().isOk())  //HTTP:status 200
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("zimug"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.reader[0].age").value(18))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("utf-8");
        log.info(result.getResponse().getContentAsString());

    }
}
