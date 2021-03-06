package com.fcant.train.servlet;

import com.fcant.train.bean.User;
import com.fcant.train.service.StudentService;
import com.fcant.train.service.UserService;
import com.fcant.train.service.impl.StudentServiceImpl;
import com.fcant.train.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * @author fcsca
 */
@Slf4j
public class UserServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    StudentService studentService = new StudentServiceImpl();

    Logger logger = Logger.getLogger(UserServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取方法名字
        String servletPath = request.getServletPath();
        // 去掉斜杠和.do
        String methodName = servletPath.substring(1, servletPath.length() - 3);
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            // 执行相应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 用户退出登录操作
     *
     * @param request
     * @param response
     * @throws ServletException
     * @author Fcscanf
     * @date 下午 15:10 2019-07-30/0030
     */
    private void quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        request.setAttribute("msg", "您已退出登录！");
        request.getRequestDispatcher("/jsp/userlogin.jsp").forward(request, response);
    }

    /**
     * 用户登录
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 19:55 2019-07-22/0022
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setUname(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        try {
            if (userService.checkUser(user)) {
                log.info("登录成功！");
                logger.info("Login Success!");
                // 登录成功后存储用户信息
                request.getSession().invalidate();
                request.getSession().setAttribute("user" , user);
                //request.setAttribute("students", studentService.selectAllStudent());
                //request.getRequestDispatcher("/jsp/studentmanager.jsp").forward(request, response);
                // TODO:完成登录后执行分页查询进入管理页面-查询是写死的
                response.sendRedirect(request.getContextPath() + "/pageQuery.action?size=5&option=0");
            } else {
                request.setAttribute("msg", "用户名或密码错误，请重新登录");
                request.getRequestDispatcher("/jsp/userlogin.jsp").forward(request, response);
                //response.sendRedirect(request.getContextPath() + "/jsp/userlogin.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用户注册
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 19:55 2019-07-22/0022
     */
    private void reg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        request.setCharacterEncoding("UTF-8");
        User user = new User();
        user.setUname(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        if (userService.findUser(user.getUname()) == null) {
            userService.addUser(user);
            request.setAttribute("msg", "您已注册成功，请登录！");
            request.getRequestDispatcher("/jsp/userlogin.jsp").forward(request, response);
        } else {
            request.setAttribute("msg" , "当前用户名已存在，请更换用户名注册或者请登录！");
            request.getRequestDispatcher("/jsp/userreg.jsp").forward(request, response);
        }
    }
}
