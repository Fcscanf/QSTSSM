package com.fcant.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * IndexController
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 19:56 2019-07-31/0031
 */
@org.springframework.stereotype.Controller
public class IndexController{

    @RequestMapping("/index")
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("message", "Hello SpringMVC");
        return mav;
    }

    @RequestMapping("/jump")
    public ModelAndView jump() {
        ModelAndView mav = new ModelAndView("redirect:index");
        return mav;
    }

    @RequestMapping("/check")
    public ModelAndView check(HttpSession session) {
        Integer i = (Integer) session.getAttribute("count");
        if (null == i) {
            i = 0;
        }
        i++;
        session.setAttribute("count", i);
        ModelAndView mav = new ModelAndView("check");
        return mav;
    }
}
