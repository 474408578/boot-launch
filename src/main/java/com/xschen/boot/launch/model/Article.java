package com.xschen.boot.launch.model;

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
public class Article {
    /**
     * id : 1
     * author : zimug
     * title : 手摸手教你开发spring boot
     * content : c
     * createTime :
     * reader : [{"name":"zimug","age":18},{"name":"kobe","age":37}]
     */

    private Long id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime createTime;
    private List<Reader> reader;


}
