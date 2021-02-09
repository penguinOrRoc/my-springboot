package com.penguin.bootweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HtmlController {
    @GetMapping("/htmlRes/{htmlPath}")
    public ModelAndView htmlRes(@PathVariable(value = "htmlPath",required = true) String htmlPath
    ){

        ModelAndView modelAndView = null;
        if("forward".equals(htmlPath)){
            modelAndView = new ModelAndView("forward:/htmlResponse/forward.html");
        } else if("redirect".equals(htmlPath)){
            modelAndView = new ModelAndView("redirect:/htmlResponse/redirect.html");
        }else{
            modelAndView = new ModelAndView("redirect:/htmlResponse/404.html");
        }
        return modelAndView;
    }
}


