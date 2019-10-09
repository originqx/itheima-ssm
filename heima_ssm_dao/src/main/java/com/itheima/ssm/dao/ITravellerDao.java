package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/27 20:07
 * @Version 1.0
 */
public interface ITravellerDao {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId = #{id})")
    List<Traveller> findByOrdersId(String id);
}
