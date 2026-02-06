package com.wenziyue.blog.article.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author wenziyue
 */
@EnableAsync
@EnableScheduling
@MapperScan("com.wenziyue.blog.article.dal.mapper")
@ComponentScan("com.wenziyue")
@SpringBootApplication(scanBasePackages = {"com.wenziyue"})
public class BlogArticleApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(BlogArticleApplication.class, args);
    }
}
