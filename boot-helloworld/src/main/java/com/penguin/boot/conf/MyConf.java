package com.penguin.boot.conf;

import com.penguin.boot.entity.HelloEntity;
import com.penguin.boot.entity.MyJDBCEntity;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@EnableConfigurationProperties(MyJDBCEntity.class)
@Configuration(proxyBeanMethods = false)
//@Configuration告诉容器这是一个配置类，等价于配置文件
//proxyBeanMethods = true  默认为true
/**
 * 1.配置类里面使用@Bean标注在方法上，给容器注册组件，默认是单实例的
 * 2.配置类本身也是一个组件
 * 3.proxyBeanMethods:代理bean的方法
 *   Full(proxyBeanMethods = false)  配置类组件之间无依赖关系用Lite模式加速容器启动过程，减少判断
 *   Lite(proxyBeanMethods = true) 配置类组件之间有依赖关系，方法会被调用得到之前的单实例组件
 *  组件依赖
 */
//@Conditional()
//@EnableConfigurationProperties(JDBCEntity.class)
public class MyConf {
    //
    @Bean
    public HelloEntity helloEntity(){
        return  new HelloEntity("hellokey","hellovalue");
    }

}


