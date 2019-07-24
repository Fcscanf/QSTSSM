package com.fcant.train.filter;

import com.fcant.train.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * PemissionFilter
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 0:51 2019-07-24/0024
 */
public class PemissionFilter implements Filter {

    /**
     * 定义不需要拦截的URL放进String数组中
     */
    private final String[] URI = {"/jsp/userlogin.jsp", "/jsp/userreg.jsp"
            , "/login.do", "/reg.do"};
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
// 将请求与响应向下转换
        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        // 获得访问界面的url文件地址
        String servletPath = req.getServletPath();
        HttpSession session = req.getSession();
        // 获取登录状态
        User user = (User) session.getAttribute("user");
        /* 判断是否是登录页、首页、登录servlet */
        if (isPassUrl(servletPath)) {
            // 是则直接转发到下一组件
            chain.doFilter(request, response);
        } else {
            // 否，则验证登录状态
            if (user != null) {
                chain.doFilter(request, response);
            } else {
                // 未登录，跳转到登录页，并保证当前网页的url文件路径
                req.setAttribute("msg", "您尚未登录，请登录");
                req.setAttribute("return_uri", servletPath);
                RequestDispatcher rd = req.getRequestDispatcher("/jsp/userlogin.jsp");
                rd.forward(req, res);
            }
        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断是不是允许通过的URL请求,如果是则返回true
     *
     * @param servletPath
     * @return true
     * @author Fcscanf
     * @date 上午 8:41 2019-07-24/0024 
     */
    private boolean isPassUrl(String servletPath) {
        if (servletPath != null) {
            for (String url : URI) {
                if (url.equals(servletPath)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
