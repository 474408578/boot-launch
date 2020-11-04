package com.xschen.boot.launch.model;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xschen
 */

@Data
public class Article implements Serializable {
    private Long id;

    private String title;

    private String author;

    private String content;

    private Date createTime;
}
