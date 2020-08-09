package com.xschen.boot.launch.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * @author xschen
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVO {

    private Long id;

    private String author;
    private String title;
    private String content;

    private Date createTime;
    private List<Reader> reader;


}