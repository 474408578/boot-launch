package com.xschen.boot.launch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author xschen
 */

@ImportResource(locations = {"classpath:otherconfig/beans.xml"})
@SpringBootApplication
public class BootLaunchApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class);
    }
}
