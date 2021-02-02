package com.penguin.bootweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ParamController {
    @GetMapping("/param1/{param1}/param2/{param2}")
    public Map<String,Object> getParam(@PathVariable("param1") Integer param1,
                                       @PathVariable("param2") Integer param2){
        Map<String,Object> map = new HashMap<>();
        map.put("param1",param1);
        map.put("param2",param2);
        return map;
    }
}


