package com.xschen.boot.launch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 *
 * 根据yml的嵌套结构，写出对应的java实体类
 * 
 */

@Data
@Component
@ConfigurationProperties(prefix = "family") // 表示配置的整体前缀, 将配置绑定到变量上
public class Family {
    // 成员变量名称要和yml配置项key一一对应
//    @Value("${family.familyName}")
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}