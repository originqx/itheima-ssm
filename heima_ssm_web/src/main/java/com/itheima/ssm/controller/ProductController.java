package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @Author: QX
 * @Date: 2019/9/24 11:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @RequestMapping("/findAll.do")
    @RolesAllowed("ADMIN")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        mv.setViewName("product-list");
        List<Product> productList = productService.findAll();
        mv.addObject("productList", productList);
        return mv;
    }

    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }
}
