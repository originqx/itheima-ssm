package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.SysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/10/9 18:44
 * @Version 1.0
 */
@Service
@Transactional
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogDao logDao;
    @Override
    public void save(SysLog log) {
        logDao.save(log);
    }

    @Override
    public List<SysLog> findAll() {
        return logDao.findAll();
    }
}
