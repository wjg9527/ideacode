package com.baizhi.dao;

import com.baizhi.entity.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String detailId);

    int insert(OrderDetail record);

    OrderDetail selectByPrimaryKey(String detailId);

    List<OrderDetail> selectAll();

    int updateByPrimaryKey(OrderDetail record);
}