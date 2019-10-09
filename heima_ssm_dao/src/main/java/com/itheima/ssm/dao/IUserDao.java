package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/29 9:58
 * @Version 1.0
 */
@Repository
public interface IUserDao {

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,property = "id" ,column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phonenum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roles" ,column = "id" ,javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findByUserId"))
    })
    UserInfo findByUsername(String username);


    @Select("select * from users")
    List<UserInfo> findAll();


    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id" ,column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phonenum"),
            @Result(property = "status" , column = "status"),
            @Result(property = "roles" ,column = "id" ,javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findByUserId"))
    })
    UserInfo findById(String id);


    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<Role> findOtherRoles(String userId);


    @Insert("insert into users_role values(#{uid},#{rid})")
    void addRoleToUser(@Param("uid") String userId, @Param("rid") String roleId);
}
