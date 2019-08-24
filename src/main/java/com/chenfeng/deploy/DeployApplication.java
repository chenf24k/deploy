package com.chenfeng.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * DEBUG调试模式启动
 * 热部署配置过程：
 * 1. spring.thymeleaf.cache=false 关闭页面缓存
 * 2. 在xml中定义devtolls
 * <dependency>
 * <groupId>org.springframework.boot</groupId>
 * <artifactId>spring-boot-devtools</artifactId>
 * </dependency>
 * <p>
 * 在maven-plugin中增加
 * <configuration>
 * <fork>true</fork>
 * </configuration>
 * 3. 修改idea的设置，如果是eclipse第三部可省略
 * file->setting->build->complier->build project auto.... 勾选
 * ctrl+shift+a 输入registry -》确保 complier.automake.... 被勾选（默认就是选中的）
 */


@SpringBootApplication
public class DeployApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("War包启动");
        return builder.sources(DeployApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DeployApplication.class, args);
    }

}
