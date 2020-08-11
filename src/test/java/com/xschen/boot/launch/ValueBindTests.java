package com.xschen.boot.launch;

import com.xschen.boot.launch.model.Employee;
import com.xschen.boot.launch.model.SystemVal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author xschen
 */

@SpringBootTest
public class ValueBindTests {
    @Resource
    Employee employee;

    @Autowired
    SystemVal systemVal;

    @Test
    public void valueBindTest() {
        System.out.println(employee.toString());
        System.out.println(systemVal.toString());
    }
}
