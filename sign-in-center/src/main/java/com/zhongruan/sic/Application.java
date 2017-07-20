package com.zhongruan.sic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zhongruan.sic.filter.JwtFilter;

@EnableAutoConfiguration
@ComponentScan
@Configuration
public class Application {

    Logger logger = LoggerFactory.getLogger(Application.class);

    // 过滤器(JwtFilter)
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/api/*");
        logger.info("@Bean jwtFiler");
        return registrationBean;
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}
