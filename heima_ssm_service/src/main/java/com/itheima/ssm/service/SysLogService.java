package com.itheima.ssm.service;

import com.itheima.ssm.domain.SysLog;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/10/9 18:44
 * @Version 1.0
 */
public interface SysLogService {
    void save(SysLog log);

    List<SysLog> findAll();
}
