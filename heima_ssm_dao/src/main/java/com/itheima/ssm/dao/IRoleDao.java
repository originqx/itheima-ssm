package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.rmi.Naming;
import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/29 10:46
 * @Version 1.0
 */
public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
                @Result(id = true,property = "id" ,column = "id"),
                @Result(property = "roleName", column = "roleName"),
                @Result(property = "roleDesc", column = "roleDesc"),
                @Result(property = "permissions", column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findByRoleId")),
            })
    List<Role> findByUserId(String userId);



    @Select("select * from role ")
    @Results({
            @Result(id = true,property = "id" ,column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermissionDao.findByRoleId")),
    })
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);


    @Select("select * from role where id = #{roleId}")
    Role findById(String roleId);


    @Select("select * from permission where id not in (select permissionId from role_permission where roleId =#{roleId})")
    List<Permission> findOtherPermission(String roleId);



    @Insert("insert into role_permission values(#{pid},#{rid})")
    void addPermissionToRole(@Param("rid") String roleId, @Param("pid") String permissionId);
}
