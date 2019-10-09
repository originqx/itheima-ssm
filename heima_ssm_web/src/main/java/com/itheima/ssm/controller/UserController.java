package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/29 11:31
 * @Version 1.0
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        List<UserInfo> users = userService.findAll();
        ModelAndView mv =new ModelAndView();
        mv.addObject("userList", users);
        mv.setViewName("user-list");
        return mv;
    }

    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username=='tom'")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String id){
        ModelAndView modelAndView =new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id" ,required = true) String userId) {
        ModelAndView mv =new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        List<Role> roleList = userService.findOtherRoles(userId);
        mv.addObject("user", userInfo);
        mv.addObject("roleList", roleList);
        mv.setViewName("user-role-add");
        return mv;
    }


    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userService.addRoleToUser(userId, roleIds);
        return "redirect:findAll.do";
    }

}
