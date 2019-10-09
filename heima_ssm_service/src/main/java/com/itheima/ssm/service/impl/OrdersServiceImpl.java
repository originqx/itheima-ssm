package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/27 10:21
 * @Version 1.0
 */
@Service
@Transactional
public class OrdersServiceImpl implements IOrdersService {
    @Autowired
    IOrdersDao ordersDao;
//    public List<Orders> findAll() {
//        return ordersDao.findAll();
//    }
public List<Orders> findAll(int page,int pageSize) {
    PageHelper.startPage(page,pageSize);
    return ordersDao.findAll();
}

    @Override
    public Orders findById(String id) {
        return ordersDao.findById(id);
    }
}
