package com.fcant.train.dao.impl;

import com.fcant.train.bean.Student;
import com.fcant.train.dao.StudentDao;
import com.fcant.train.utils.JDBCUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentDaoImpl
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 14:46 2019-07-22/0022
 */
@Slf4j
public class StudentDaoImpl implements StudentDao {

    Connection connection = JDBCUtils.getConnection();

    /**
     * 根据姓名查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    @Override
    public Student findStudentByName(Student student) throws SQLException {
        Student findStudent = new Student();
        String sql = "SELECT * from t_student s where s.name=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getName());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            findStudent.setId(resultSet.getInt(1));
            findStudent.setName(resultSet.getString(2));
            findStudent.setEmail(resultSet.getString(3));
            findStudent.setPhone(resultSet.getString(4));
            findStudent.setQq(resultSet.getString(5));
            log.info("Find Student : " + findStudent.toString());
        }
        return findStudent;
    }

    /**
     * 根据姓名查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    @Override
    public Student findStudentById(Student student) throws SQLException {
        Student findStudent = new Student();
        String sql = "SELECT * from t_student s where s.id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, student.getId());
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            findStudent.setId(resultSet.getInt(1));
            findStudent.setName(resultSet.getString(2));
            findStudent.setEmail(resultSet.getString(3));
            findStudent.setPhone(resultSet.getString(4));
            findStudent.setQq(resultSet.getString(5));
            log.info("Find Student : " + findStudent.toString());
        }
        return findStudent;
    }

    /**
     * 添加学生
     *
     * @param student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:49 2019-07-22/0022
     */
    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "insert into t_student(name, email, phone, qq) values (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3, student.getPhone());
        statement.setString(4, student.getQq());
        int i = statement.executeUpdate();
        log.info("Add Student : " + student.toString());
    }

    /**
     * 更新学生信息
     *
     * @param student
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 15:38 2019-07-22/0022
     */
    @Override
    public int updateStudent(Student student) throws SQLException {
        String sql = "update t_student s set s.name=?,s.email=?,s.phone=?,s.qq=? where s.id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, student.getName());
        statement.setString(2, student.getEmail());
        statement.setString(3, student.getPhone());
        statement.setString(4, student.getQq());
        statement.setInt(5,student.getId());
        int i = statement.executeUpdate();
        log.info("Update Student : " + student.toString());
        return i;
    }

    /**
     * 查询所有学生信息
     *
     * @return 学生信息列表
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    @Override
    public List<Student> selectAllStudent() throws SQLException {
        String sql = "select * from t_student";
        List<Student> students = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            Student student = new Student();
            student.setId(resultSet.getInt(1));
            student.setName(resultSet.getString(2));
            student.setEmail(resultSet.getString(3));
            student.setPhone(resultSet.getString(4));
            student.setQq(resultSet.getString(5));
            students.add(student);
        }
        log.info("Query All Student Message : ");
        for (Student student : students) {
            log.info(student.toString());
        }
        return students;
    }
}
