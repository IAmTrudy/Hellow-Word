package com.lxp.hello;

import com.lxp.hello.bean.HelloBean;
import org.apache.naming.factory.BeanFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.Resource;

@SpringBootTest
class HelloApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void set(){
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.setKeySerializer(RedisSerializer.string());
        redisTemplate.opsForValue().set("myKey","myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
        redisTemplate.delete("myKey");
    }

}
