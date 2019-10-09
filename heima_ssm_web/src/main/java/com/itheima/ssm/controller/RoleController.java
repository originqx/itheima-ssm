package com.itheima.ssm.controller;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.management.relation.RoleResult;
import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/30 13:54
 * @Version 1.0
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    IRoleService roleService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv =new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList", roleList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id", required = true) String roleId) {
        Role role = roleService.findById(roleId);
        List<Permission> permissionList=  roleService.findOtherPermission(roleId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.addObject("permissionList", permissionList);
        mv.setViewName("role-permission-add");
        return mv;
    }


    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(String roleId, String[] permissions ){
        roleService.addPermissionToRole(roleId, permissions);
        return "redirect:findAll.do";
    }

}
