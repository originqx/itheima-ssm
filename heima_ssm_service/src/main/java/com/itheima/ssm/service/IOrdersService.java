package com.itheima.ssm.service;

import com.itheima.ssm.domain.Orders;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/27 10:21
 * @Version 1.0
 */
public interface IOrdersService {
//    List<Orders> findAll();

    List<Orders> findAll(int page, int pageSize);

    Orders findById(String id);
}
