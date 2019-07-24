package com.fcant.train.service.impl;

import com.fcant.train.bean.Page;
import com.fcant.train.bean.Student;
import com.fcant.train.dao.StudentDao;
import com.fcant.train.dao.impl.StudentDaoImpl;
import com.fcant.train.service.StudentService;
import lombok.extern.slf4j.Slf4j;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * StudentServiceImpl
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 14:47 2019-07-22/0022
 */
@Slf4j
public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();

    /**
     * 查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    @Override
    public Student findStudent(Student student) throws SQLException {
        return studentDao.findStudentById(student);
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
    public boolean addStudent(Student student) throws SQLException {
        if (checkEmail(student.getEmail())) {
            log.info("Email Right!!!");
            if (checkPhone(student.getPhone())) {
                log.info("Phone Number Right!!!");
                studentDao.addStudent(student);
                return true;
            } else {
                log.info("False Phone Number!!!");
                return false;
            }
        } else {
            log.info("False Email!!!");
            return false;
        }
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
    public boolean updateStudent(Student student) throws SQLException {
        if (checkEmail(student.getEmail())) {
            log.info("Email Right!!!");
            if (checkPhone(student.getPhone())) {
                log.info("Phone Number Right!!!");
                studentDao.updateStudent(student);
                return true;
            } else {
                log.info("False Phone Number!!!");
                return false;
            }
        } else {
            log.info("False Email!!!");
            return false;
        }
    }

    /**
     * 查询所有学生信息
     *
     * @return
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    @Override
    public List<Student> selectAllStudent() throws SQLException {
        return studentDao.selectAllStudent();
    }

    /**
     * 模糊查询
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    @Override
    public List<Student> likeSelectStudent(Student student) throws SQLException {
        return studentDao.likeSelectStudent(student);
    }

    /**
     * 分页查询数据
     *
     * @param page
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 18:24 2019-07-23/0023
     */
    @Override
    public List<Student> pageQueryStudent(Page page) throws SQLException {
        return studentDao.pageQueryStudent(page);
    }

    /**
     * 删除学生
     *
     * @param student
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:31 2019-07-24/0024
     */
    @Override
    public int deleteStu(Student student) throws SQLException {
        return studentDao.deleteStu(student);
    }

    /**
     * 校验邮箱 
     *
     * @param email
     * @return true
     *          校验通过返回true
     *          校验失败返回false
     * @author Fcscanf
     * @date 下午 17:10 2019-07-22/0022 
     */
    public boolean checkEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);
    }

    /**
     * 校验手机号
     *
     * @param phone
     * @return true
     * @author Fcscanf
     * @date 下午 17:14 2019-07-22/0022
     */
    public boolean checkPhone(String phone) {
        return Pattern.matches("^((1[0-9][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", phone);
    }
}
