package com.baizhi.controller;

import com.baizhi.entity.Cart;
import com.baizhi.entity.ProductInfo;
import com.baizhi.feign.ProductFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("car")
public class CarController {
    @Autowired
    private ProductFeign productFeign;
    @HystrixCommand(fallbackMethod = "cartFallback")
    @RequestMapping(value = "add")
    public ProductInfo list(String id, HttpServletRequest request){
        ProductInfo one = productFeign.findOne(id);
        HttpSession session = request.getSession();
        Map<String,Cart> cart = (HashMap)session.getAttribute("cart");
        if(cart==null){
            Cart cart1 = new Cart();
            cart1.setName(one.getProdcutName());
            cart1.setProductId(one.getProductId());
            cart1.setProductPrice(one.getProductPrice());
            cart1.setCount(new BigDecimal(1));
            Map<String,Cart> map = new HashMap();
            map.put(one.getProductId(),cart1);
            session.setAttribute("cart",map);
        }else {
            Cart cart1 = new Cart();
            cart1.setName(one.getProdcutName());
            cart1.setProductId(one.getProductId());
            cart1.setProductPrice(one.getProductPrice());
            if(cart.containsKey(id)){
                Cart cart2 = cart.get(id);
                cart2.setCount(cart2.getCount().add(new BigDecimal(1)));
                cart.put(id,cart2);
            } else {
                    cart1.setCount(new BigDecimal(1));
                    cart.put(id,cart1);
            }
            session.setAttribute("cart",cart);
        }
        return one;
    }
    public ProductInfo cartFallback(String id, HttpServletRequest request){
        ProductInfo productInfo = new ProductInfo();
        return productInfo;
    }

}
