package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.beans.PersistenceDelegate;
import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/29 18:16
 * @Version 1.0
 */
public interface IPermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{roleId})")
    List<Permission> findByRoleId(String roleId);


    @Select("select * from permission")
    List<Permission> findAll();


    @Insert("insert into permission(permissionName,url) value(#{permissionName},#{url})")
    void save(Permission permission);
}
