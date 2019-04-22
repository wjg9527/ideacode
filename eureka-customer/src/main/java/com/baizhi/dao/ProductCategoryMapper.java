package com.baizhi.dao;

import com.baizhi.entity.ProductCategory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface ProductCategoryMapper extends Mapper<ProductCategory> {
List<ProductCategory> findAll();
}