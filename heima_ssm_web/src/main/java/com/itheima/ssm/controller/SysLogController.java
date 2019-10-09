package com.itheima.ssm.controller;

import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.SysLogService;
import org.apache.log4j.net.SyslogAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/10/9 19:43
 * @Version 1.0
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    SysLogService logService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        List<SysLog> logList = logService.findAll();
        ModelAndView mv =new ModelAndView();
        mv.setViewName("syslog-list");
        mv.addObject("sysLogs", logList);
        return  mv;
    }
}
