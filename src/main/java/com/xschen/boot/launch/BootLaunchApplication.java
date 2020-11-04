package com.xschen.boot.launch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
/**
 * @author xschen
 */

@ImportResource(locations = {"classpath:/otherconfig/beans.xml"})
@MapperScan(basePackages = {"com.xschen.boot.launch.mapper"})
@SpringBootApplication
public class BootLaunchApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class);
    }
}
