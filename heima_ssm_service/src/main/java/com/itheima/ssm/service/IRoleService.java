package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/30 13:55
 * @Version 1.0
 */
public interface IRoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(String roleId);

    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] permissions);
}
