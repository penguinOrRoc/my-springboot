package com.penguin.boot;

import com.penguin.boot.entity.HelloEntity;
import com.penguin.boot.entity.MyJDBCEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
/**
 * 标识当前程序是一个SpringBoot应用
 *  是以下三个注解的组合
 * @SpringBootConfiguration  //代表当前类是一个配置类
 * @ComponentScan("com.penguin.boot")  //指定要扫描的包，参考Spring注解版
 * @EnableAutoConfiguration 开启自动配置的注解
 * 是以下两个注解的集合
 * @AutoConfigurationPackage = …… + @Import({Registrar.class})
 * 利用Register给容器导入一系列组件
 * 将指定的一个包下的所有组件导入
 * @Import({AutoConfigurationImportSelector.class})
 */
public class BootApplication {
    public static void main(String[] args){
        //SpringBoot的主程序，创建了一个ApplicationContext容器
        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(BootApplication.class);
        //查看容器中的组件
        String[] names = configurableApplicationContext.getBeanDefinitionNames();
        //获取容器的组件
        HelloEntity helloEntity01 = (HelloEntity)configurableApplicationContext.getBean("helloEntity");
        HelloEntity helloEntity02 = (HelloEntity)configurableApplicationContext.getBean("helloEntity");
        System.out.println(helloEntity01 == helloEntity02);


        MyJDBCEntity myJDBCEntity = (MyJDBCEntity)configurableApplicationContext.getBean("myJDBCEntity");
        System.out.println(myJDBCEntity.toString());





    }
}



