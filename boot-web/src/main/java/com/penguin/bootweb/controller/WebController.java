package com.penguin.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    @RequestMapping("/staticResources")
    public String staticResources(){
        return "静态资源测试";
    }

    @RequestMapping(value = "/hello",method = RequestMethod.POST)
    public String addHello(){
        return "新增Hello~";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.DELETE)
    public String delHello(){
        return "删除Hello~";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.PUT)
    public String updateHello(){
        return "更新Hello~";
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String selHello(){
        return "查询Hello~";
    }


}


