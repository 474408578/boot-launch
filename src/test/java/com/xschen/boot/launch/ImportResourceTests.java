package com.xschen.boot.launch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xschen
 */

@SpringBootTest
public class ImportResourceTests {

    @Autowired
    private ConfigurableApplicationContext ioc;

    @Test
    public void testHelloService() {
        boolean testBeanService = ioc.containsBean("testBeanService");
        System.out.println(testBeanService);
    }
}
