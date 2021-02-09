package com.penguin.bootweb.controller;

import com.penguin.bootweb.entity.DemoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

    @GetMapping("thymeleafTest")
    public String thymeleafTest(DemoEntity demoEntity,Model model){
        if("彭".equals(demoEntity.getFname())){
            model.addAttribute("thymeleaf","彭，成功了~");
        }else{
            model.addAttribute("thymeleaf","你不是彭！！！~");
        }
        return "success.html";
    }
    @GetMapping("/thymeleaf/{htmlPath}")
    public String htmlRes(@PathVariable(value = "htmlPath",required = true) String htmlPath,Model
                          model
    ){
        model.addAttribute("htmlPath",htmlPath);
        return "forward:/index.html";
    }
}


