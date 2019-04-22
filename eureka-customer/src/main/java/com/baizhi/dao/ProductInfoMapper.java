package com.baizhi.dao;

import com.baizhi.entity.ProductInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductInfoMapper extends Mapper<ProductInfo> {

    List<ProductInfo> findAll();


}