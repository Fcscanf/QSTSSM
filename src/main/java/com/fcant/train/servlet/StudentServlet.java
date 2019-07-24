package com.fcant.train.servlet;

import com.fcant.train.bean.Page;
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
import java.util.HashMap;
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

    HashMap<String, Page> PAGE_MESSAGE = new HashMap<>();

    private final String optionNext = "next";
    private final String optionPre = "pro";

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
     * 删除学生信息
     *
     * @param request
     * @param response
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:44 2019-07-24/0024 
     */
    private void delete(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Student student = new Student();
        int delId = Integer.parseInt(request.getParameter("id"));
        student.setId(delId);
        studentService.deleteStu(student);
        // TODO:删除后要分页进行主界面-未完善
    }
    /**
     * 添加学生信息
     *
     * @param request
     * @param response
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:41 2019-07-24/0024
     */
    private void add(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));
        student.setPhone(request.getParameter("phone"));
        student.setQq(request.getParameter("qq"));
        studentService.addStudent(student);
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
     * TODO:查询时要判断操作起始页越界以及出现页面条数为不合法数据的情况
     *
     * @param request
     * @param response
     * @throws SQLException
     * @throws ServletException
     * @author Fcscanf
     * @date 下午 18:38 2019-07-23/0023
     */
    private void pageQuery(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        Page page = new Page();
        String option = request.getParameter("option");
        int start = 0;
        int userSetPageSize = Integer.parseInt(request.getParameter("size"));
        page.setSize(userSetPageSize);
        if (optionNext.equals(option)) {
            Page curPage = PAGE_MESSAGE.get("1");
            curPage.setStart(curPage.getStart() + userSetPageSize);
            PAGE_MESSAGE.put("1", curPage);
            rePageQuery(request, response, curPage);
        } else if (optionPre.equals(option)) {
            Page curPage = PAGE_MESSAGE.get("1");
            curPage.setStart(curPage.getStart() - userSetPageSize);
            PAGE_MESSAGE.put("1", curPage);
            rePageQuery(request, response, curPage);
        } else {
            page.setStart(start);
            page.setSize(Integer.parseInt(request.getParameter("size")));
            PAGE_MESSAGE.put("1", page);
            rePageQuery(request, response, page);
        }
    }

    /**
     * 分页查询返回
     *
     * @param request
     * @param response
     * @param page
     * @throws SQLException
     * @throws ServletException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 23:51 2019-07-23/0023
     */
    private void rePageQuery(HttpServletRequest request, HttpServletResponse response, Page page) throws SQLException, ServletException, IOException {
        List<Student> students = studentService.pageQueryStudent(page);
        request.setAttribute("students", students);
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
