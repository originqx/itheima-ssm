package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: QX
 * @Date: 2019/9/27 19:59
 * @Version 1.0
 */
public interface IMemberDao {
    @Select("select * from member where id = #{id}")
     Member findById(String id);
}
