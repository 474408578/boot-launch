package com.xschen.boot.launch;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xschen
 */

@ImportResource(locations = {"classpath:beans.xml"})
@MapperScan(basePackages = {"com.xschen.boot.launch.generator"})
@SpringBootApplication
public class BootLaunchApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(BootLaunchApplication.class);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        generateArtifacts();
    }

    // 执行后mybatis generator会根据表为我们实体类，以及对应的Mapper
    private void generateArtifacts() throws Exception {
        List<String> warings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warings);
        Configuration config = cp.parseConfiguration(this.getClass().getResourceAsStream("/generatorConfig.xml"));
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warings);
        myBatisGenerator.generate(null);
    }
}
