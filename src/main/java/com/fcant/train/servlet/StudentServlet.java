package com.fcant.train.servlet;

import com.fcant.train.bean.Student;
import com.fcant.train.service.StudentService;
import com.fcant.train.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

/**
 * StudentServlet
 *
 * encoding:UTF-8
 * @author Fcscanf
 * @date 上午 0:23 2019-07-23/0023
 */
public class StudentServlet extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();

    /**
     * 进行Servlet反射处理多请求
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 23:50 2019-07-22/0022
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取方法名字
        String servletPath = request.getServletPath();
        // 去掉斜杠和.do
        String methodName = servletPath.substring(1, servletPath.length() - 7);
        System.out.println(methodName);
        try {
            // 利用反射获取方法
            Method method = getClass().getDeclaredMethod(methodName,
                    HttpServletRequest.class, HttpServletResponse.class);
            // 执行相应的方法
            method.invoke(this, request, response);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    /**
     * 回调doPost方法
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 23:51 2019-07-22/0022
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 处理student编辑请求，将student信息查询完整并回显至页面
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 23:53 2019-07-22/0022
     */
    private void edit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Student student = new Student();
        student.setId(Integer.parseInt(request.getParameter("id")));
        Student reStudent = studentService.findStudent(student);
        request.setAttribute("student", reStudent);
        request.getRequestDispatcher("/jsp/editstudent.jsp").forward(request, response);
    }

    /**
     * 处理Student-Update请求 
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @author Fcscanf
     * @date 上午 0:22 2019-07-23/0023 
     */
    private void update(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Student student = new Student();
        String id = request.getParameter("id");
        student.setId(Integer.parseInt(id));
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setPhone(request.getParameter("phone"));
        student.setQq(request.getParameter("qq"));
        studentService.updateStudent(student);
    }

    private void getstuall(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Student> students = studentService.selectAllStudent();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/jsp/studentmanager.jsp").forward(request, response);
    }

//    private void reeditstu(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("student", student);
//        request.getRequestDispatcher("/jsp/editstudent.jsp").forward(request, response);
//    }
}
