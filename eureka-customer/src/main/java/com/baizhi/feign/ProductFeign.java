package com.baizhi.feign;

import com.baizhi.entity.ProductInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(serviceId = "eureka-client")
public interface ProductFeign {
    @RequestMapping(value = "/product/list",method = RequestMethod.GET)
    public Map<String, Object> list();
    @RequestMapping(value = "/product/findOne",method = RequestMethod.GET)
    public ProductInfo findOne(@RequestParam("id") String id);

}
