package com.lxp.hello.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:application.properties")
@Component
public class DataBaseInfo {

    @Value("${spring.datasource.username}")
    private static String username;
    @Value("${spring.datasource.password}")
    private static String password;
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.driver-class-name}")
    private static String driverClass;

    public static void print(){
        System.out.println(username);
        System.out.println(password);
        System.out.println(url);
        System.out.println(driverClass);
    }
}
