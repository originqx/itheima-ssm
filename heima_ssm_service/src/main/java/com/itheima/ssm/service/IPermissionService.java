package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/30 14:30
 * @Version 1.0
 */
public interface IPermissionService {
    List<Permission> findAll();

    void save(Permission permission);
}
