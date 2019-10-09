package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/29 9:44
 * @Version 1.0
 */
public interface IUserService extends UserDetailsService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(String id);
    List<Role> findOtherRoles(String userId);

    void addRoleToUser(String userId, String[] roleIds);
}
