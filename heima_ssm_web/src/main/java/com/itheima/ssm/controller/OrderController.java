package com.itheima.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.ssm.domain.Orders;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/27 10:17
 * @Version 1.0
 */
@Controller
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    IOrdersService ordersService;
    /*
    分页前
     */
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll(){
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ordersList = ordersService.findAll();
//        mv.addObject("ordersList", ordersList);
//        mv.setViewName("orders-list");
//        return mv;
//    }
    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") Integer page,@RequestParam(name = "pageSize",required = true,defaultValue = "3") Integer pageSize){
        ModelAndView mv = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(page, pageSize);
        PageInfo pageInfo = new PageInfo(ordersList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("orders-page-list");
        return mv;
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        ModelAndView mv = new ModelAndView();
        Orders order = ordersService.findById(id);
        mv.addObject("orders", order);
        mv.setViewName("orders-show");
        return mv;
    }
}
