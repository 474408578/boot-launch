package com.xschen.boot.launch.model;

import lombok.Data;

import java.util.List;

/**
 * @author xschen
 */


@Data
public class Child {

    private String name;
    private int age;

    private List<Friend> friends;
}
