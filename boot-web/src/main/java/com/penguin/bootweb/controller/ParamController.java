package com.penguin.bootweb.controller;

import org.springframework.web.bind.annotation.*;

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
    //http://localhost:8000/queryString/strPath?name=%E5%BD%AD%E7%8E%87&sex=%E7%94%B7
    @GetMapping("/queryString/{path}")
    public Map<String,Object> getQueryString(@RequestParam("name") String name,@RequestParam("sex") String sex,@PathVariable("path")String path){
        Map<String,Object> map = new HashMap<>();
        map.put("pathStr",path);
        map.put("nameStr",name);
        map.put("sexStr",sex);
        return map;
    }
    //http://localhost:8000/matrixVariable/matrixPath;name=%E5%BD%AD%E7%8E%87;sex=%E7%94%B7
    @GetMapping("/matrixVariable/{path}")
    public Map<String,Object> getMatrixVariable(
            @MatrixVariable("name") String name,
            @MatrixVariable("sex") String sex,
            @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();
        map.put("pathmatrix",path);
        map.put("namematrix",name);
        map.put("sexmatrix",sex);
        return map;
    }
}


