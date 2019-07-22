package com.fcant.train.test.dao;

import com.fcant.train.service.StudentService;
import com.fcant.train.service.impl.StudentServiceImpl;

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
        StudentService studentService = new StudentServiceImpl();
        studentService.selectAllStudent();
    }
}
