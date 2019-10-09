package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/24 11:24
 * @Version 1.0
 */
public interface IProductService {
    List<Product> findAll() throws Exception;
    void save(Product product);
}
