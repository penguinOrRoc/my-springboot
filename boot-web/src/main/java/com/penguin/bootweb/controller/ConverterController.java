package com.penguin.bootweb.controller;

import com.penguin.bootweb.entity.ConvertorEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ConverterController {
    @PostMapping("/converter")
    public Map<String,Object> addName(ConvertorEntity entity){
        Map<String,Object> map = new HashMap<>();
        map.put("fname",entity.getFname());
        map.put("lname",entity.getLname());
        if(entity.getConvertorRefEntity() != null){
          map.put("reffname",entity.getConvertorRefEntity().getReffname());
          map.put("reflname",entity.getConvertorRefEntity().getReflname());
        }else {
            map.put("reffname",null);
            map.put("reflname",null);
        }
        return map;
    }
}


