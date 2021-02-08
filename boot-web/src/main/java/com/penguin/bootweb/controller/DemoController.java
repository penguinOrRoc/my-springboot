package com.penguin.bootweb.controller;

import com.penguin.bootweb.entity.DemoEntity;
import com.penguin.bootweb.entity.DemoRefEntity;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class DemoController {

    @PostMapping("/jsonRes")
    public DemoEntity jsonRes(DemoEntity entity){
        Map<String,Object> map = new HashMap<>();
        DemoRefEntity ref = new DemoRefEntity();
        ref.setReffname(entity.getFname()+"res");
        ref.setReflname(entity.getLname()+"res");
        entity.setDemoRefEntity(ref);
        map.put("res",entity);
        return entity;
    }
    @GetMapping("/FileSystemResource/{filename}")
    public FileSystemResource fileSystemResource(@PathVariable(value = "filename",required = true) String filename){
        String filepath = "C:\\Users\\Administrator\\Pictures\\" + filename;
        FileSystemResource fileSystemResource = new FileSystemResource(filepath);
        return fileSystemResource;
    }


    @PostMapping("/converter")
    public Map<String,Object> addName(DemoEntity entity){
        Map<String,Object> map = new HashMap<>();
        map.put("fname",entity.getFname());
        map.put("lname",entity.getLname());
        if(entity.getDemoRefEntity() != null){
            map.put("reffname",entity.getDemoRefEntity().getReffname());
            map.put("reflname",entity.getDemoRefEntity().getReflname());
        }else {
            map.put("reffname",null);
            map.put("reflname",null);
        }
        return map;
    }





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
