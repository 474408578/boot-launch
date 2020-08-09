package com.xschen.boot.launch.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author xschen
 */

@Data
@Builder
@JsonPropertyOrder(value = {"content", "title"}) // 改变子属性在JSON序列化中的默认定义的顺序。如：content在先，title在后。
public class Article {
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

    @JsonIgnore // 排除某个属性不做序列化与反序列化
    private Long id;

     @JsonProperty("auther") // 为某个属性换一个名称，体现在JSON数据里面
    private String author;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL) // 排除为空的元素不做序列化与反序列化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    private List<Reader> reader;
}
