package com.fcant.train.test.dao;

import com.fcant.train.bean.Student;
import com.fcant.train.dao.StudentDao;
import com.fcant.train.dao.impl.StudentDaoImpl;

import java.sql.SQLException;

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
        Student student = new Student();
        student.setId(13);
        StudentDao studentDao = new StudentDaoImpl();
        System.out.println(studentDao.deleteStu(student));
    }
}
