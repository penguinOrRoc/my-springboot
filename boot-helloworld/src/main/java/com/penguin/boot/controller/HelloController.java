package com.penguin.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
        //  相当于@ResponseBody + @Controller
public  class HelloController{
//    @Autowired
//    JDBCEntity jdbcEntity;

    @ResponseBody //标识当前方法，返回的是一个值，无需跳转到页面（也可对类进行注解）
    @RequestMapping("/hello")
    public String helloworld(){

        return "hello";
    }
}