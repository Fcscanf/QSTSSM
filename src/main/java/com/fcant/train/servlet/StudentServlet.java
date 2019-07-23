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
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @date 上午 0:23 2019-07-23/0023
 */
public class StudentServlet extends HttpServlet {

    StudentService studentService = new StudentServiceImpl();

    private final String ID= "id";
    private final String NAME= "name";
    private final String EMAIL= "email";
    private final String PHONE= "phone";
    private final String QQ= "qq";

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

    /**
     * 获取所有学生信息
     *
     * @param request
     * @param response
     * @return
     * @throws SQLException
     * @throws ServletException
     * @author Fcscanf
     * @date 上午 11:14 2019-07-23/0023
     */
    private void getstuall(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Student> students = studentService.selectAllStudent();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/jsp/studentmanager.jsp").forward(request, response);
    }

    /**
     * 按条件检索查找
     * TODO:此处赋值需要优化
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @author Fcscanf
     * @date 下午 16:24 2019-07-23/0023
     */
    private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Student student = new Student();
        String selectType = request.getParameter("select");
        String value = request.getParameter("value");
        if (ID.equals(selectType)) {
            student.setId(Integer.parseInt(value));
            reLikeQuery(request, response, student);
        } else if (NAME.equals(selectType)) {
            student.setName(value);
            reLikeQuery(request, response, student);
        } else if (EMAIL.equals(selectType)) {
            student.setName("");
            student.setEmail(value);
            reLikeQuery(request, response, student);
        } else if (PHONE.equals(selectType)) {
            student.setName("");
            student.setEmail("");
            student.setPhone(value);
            reLikeQuery(request, response, student);
        } else if (QQ.equals(selectType)) {
            student.setName("");
            student.setEmail("");
            student.setPhone("");
            student.setQq(value);
            reLikeQuery(request, response, student);
        }
    }

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @author Fcscanf
     * @date 下午 18:38 2019-07-23/0023
     */
    private void pageQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int start = Integer.parseInt(request.getParameter("start"));
        int end = Integer.parseInt(request.getParameter("end"));
        request.setAttribute("students", studentService.pageQueryStudent(start, end));
        request.getRequestDispatcher("/jsp/studentmanager.jsp").forward(request, response);
    }

    /**
     *  模糊查询返回的结果以及资源映射
     *
     * @param request
     * @param response
     * @param student
     * @throws SQLException
     * @throws IOException
     * @throws ServletException
     * @author Fcscanf
     * @date 下午 17:07 2019-07-23/0023
     */
    private void reLikeQuery(HttpServletRequest request, HttpServletResponse response, Student student) throws SQLException, ServletException, IOException {
        request.setAttribute("students", studentService.likeSelectStudent(student));
        request.getRequestDispatcher("/jsp/studentmanager.jsp").forward(request, response);
    }

//    private void reeditstu(HttpServletRequest request, HttpServletResponse response) {
//        request.setAttribute("student", student);
//        request.getRequestDispatcher("/jsp/editstudent.jsp").forward(request, response);
//    }
}
