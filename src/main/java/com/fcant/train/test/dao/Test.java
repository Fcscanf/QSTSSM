package com.fcant.train.test.dao;

import com.fcant.train.bean.Page;
import com.fcant.train.bean.Student;
import com.fcant.train.service.StudentService;
import com.fcant.train.service.impl.StudentServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Test
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 11:18 2019-07-22/0022
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Page page = new Page();
        page.setStart(0);
        page.setSize(20);
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.pageQueryStudent(page);
        for (Student student1 : students) {
            System.out.println(student1.toString());
        }
    }
}
