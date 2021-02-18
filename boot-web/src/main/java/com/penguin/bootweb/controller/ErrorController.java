package com.penguin.bootweb.controller;

import com.penguin.bootweb.entity.DemoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @GetMapping("error/{num}")
    public Integer thymeleafTest(@PathVariable(value = "num",required = true) Integer num){

        Integer res = 10/num;
        return res;
    }
    @GetMapping("error")
    @ResponseBody
    public String error(){

        return "error";
    }

}


