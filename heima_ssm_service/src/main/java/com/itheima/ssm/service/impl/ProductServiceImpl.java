package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/24 11:26
 * @Version 1.0
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    IProductDao procuctDao;
    public List<Product> findAll() throws Exception {
        return procuctDao.findAll();
    }

    @Override
    public void save(Product product) {
        procuctDao.save(product);
    }
}
