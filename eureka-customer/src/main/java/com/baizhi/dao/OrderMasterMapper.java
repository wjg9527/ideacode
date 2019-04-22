package com.baizhi.dao;

import com.baizhi.entity.OrderMaster;

import java.util.List;

public interface OrderMasterMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(OrderMaster record);

    OrderMaster selectByPrimaryKey(String orderId);

    List<OrderMaster> selectAll();

    int updateByPrimaryKey(OrderMaster record);
}