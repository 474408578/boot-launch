package com.xschen.boot.launch;

import com.xschen.boot.launch.model.Family;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xschen
 */

@SpringBootTest
public class CustomYamlTest {
    @Autowired
    Family family;

    @Test
    public void hello() {
        System.out.println(family.toString());
    }
}
