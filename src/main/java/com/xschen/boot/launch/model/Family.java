package com.xschen.boot.launch.model;

import com.xschen.boot.launch.utils.MixPropertySourceFactory;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

/**
 * @author xschen
 *
 * 根据yml的嵌套结构，写出对应的java实体类
 *
 */

@Data
@Component
@ConfigurationProperties(prefix = "family") // 表示配置的整体前缀, 将配置绑定到变量上
@Validated // 对绑定的属性值进行校验
@PropertySource(value = {"classpath:otherconfig/family.yml"}, factory = MixPropertySourceFactory.class)
public class Family {
    // 成员变量名称要和yml配置项key一一对应
//    @Value("${family.familyName}")
    @NotEmpty // 校验familyName必须不能为空
    private String familyName;
    private Father father;
    private Mother mother;
    private Child child;
}
