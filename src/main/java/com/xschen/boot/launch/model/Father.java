package com.xschen.boot.launch.model;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * @author xschen
 */

@Data
public class Father {
    private String name;
//    @Min(21) // 验证年龄的最小值为21
    private int age;
}
