package com.baizhi.controller;

import com.baizhi.feign.ProductFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductFeign productFeign;
    @HystrixCommand(fallbackMethod = "productFallback")
    @RequestMapping(value = "list")
    public Map<String, Object> list(){
        Map<String, Object> map = productFeign.list();
        return map;
    }
    public Map<String, Object> productFallback(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg","失败");
        map.put("code","1");
        return map;
    }
}
