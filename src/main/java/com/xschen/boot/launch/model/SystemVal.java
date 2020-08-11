package com.xschen.boot.launch.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author xschen
 */


@Data
@Component
public class SystemVal {
    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
