package com.penguin.bootweb.controller;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ReturnController {

    @ResponseBody
    @GetMapping("/jsonRes")
    public Map<String,Object> jsonRes(@RequestParam(value = "param1",required = false) Integer param1,
                                      @RequestParam(value = "param2",required = false) Integer param2){
        Map<String,Object> map = new HashMap<>();
        map.put("param1",param1);
        map.put("param2",param2);
        return map;
    }
    @GetMapping("/htmlRes/{htmlPath}")
    public ModelAndView htmlRes(@PathVariable(value = "htmlPath",required = true) String htmlPath
                                ){

        ModelAndView modelAndView = null;
        if("forward".equals(htmlPath)){
            modelAndView = new ModelAndView("forward:/forward.html");
        } else if("redirect".equals(htmlPath)){
            modelAndView = new ModelAndView("redirect:/redirect.html");
        }else{

        }
        return modelAndView;
    }
    @ResponseBody
    @GetMapping("/resource/{sourcename}")
    public Resource getResource(@PathVariable(value = "sourcename",required = true) String sourcename){
        return null;
    }
}


