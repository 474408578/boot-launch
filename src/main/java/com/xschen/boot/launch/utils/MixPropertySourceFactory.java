package com.xschen.boot.launch.utils;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author xschen
 *
 * spring不支持使用@PropertySource加载YAML配置文件，
 * DefaultPropertySourceFactory配置文件夹在的工厂类，通过集成DefaultPropertySourceFactory，
 * 然后重写下他的createPropertySource，从而实现yaml的额外配置文件加载。
 */


public class MixPropertySourceFactory extends DefaultPropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();

        if (sourceName != null && (sourceName.endsWith(".yml")) || sourceName.endsWith("yaml")) {
            Properties properties = loadYml(resource);
            return new PropertiesPropertySource(sourceName, properties);
        }
        return super.createPropertySource(name, resource);
    }

    private Properties loadYml(EncodedResource resource) {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
