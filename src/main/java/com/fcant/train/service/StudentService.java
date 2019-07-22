package com.fcant.train.service;

import com.fcant.train.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * StudentService
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 14:46 2019-07-22/0022
 */
public interface StudentService {
    /**
     * 查找学生
     *
     * @param student
     * @return student
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    public Student findStudent(Student student) throws SQLException;

    /**
     * 添加学生
     *
     * @param student
     * @author Fcscanf
     * @date 下午 14:49 2019-07-22/0022
     */
    public boolean addStudent(Student student) throws SQLException;

    /**
     * 更新学生信息
     *
     * @param student
     * @return int
     * @throws  SQLException
     * @author Fcscanf
     * @date 下午 15:38 2019-07-22/0022
     */
    public boolean updateStudent(Student student) throws SQLException;

    /**
     * 查询所有学生信息
     *
     * @return
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    public List<Student> selectAllStudent() throws SQLException;
}
