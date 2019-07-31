package com.fcant.springmvc.controller;

import com.fcant.springmvc.bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductController
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 22:45 2019-07-31/0031
 */
@Controller
public class ProductController {
    @RequestMapping("/addProduct")
    public ModelAndView add(Product product) throws Exception {
        ModelAndView mav = new ModelAndView("showProduct");
        return mav;
    }
}
