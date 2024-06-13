package org.hx.aisite;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SpringBoot 启动类
 *
 * @return
 * @date 2024/6/5 8:47
 **/
@SpringBootApplication
@MapperScan("org.hx.aisite.**.dao")
public class AiSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiSiteApplication.class, args);
    }
}
