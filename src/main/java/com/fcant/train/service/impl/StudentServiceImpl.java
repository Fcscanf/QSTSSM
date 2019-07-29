package com.fcant.train.service.impl;

import com.fcant.train.bean.Page;
import com.fcant.train.bean.Student;
import com.fcant.train.dao.StudentDao;
import com.fcant.train.dao.impl.StudentDaoImpl;
import com.fcant.train.mapper.StudentMapper;
import com.fcant.train.service.StudentService;
import com.fcant.train.utils.MybatisUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
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
     * @throws IOException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    @Override
    public Student findStudent(Student student) throws SQLException, IOException {
        //return studentDao.findStudentById(student);
        SqlSession sqlSession = MybatisUtil.initMybatis();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student studentById = mapper.findStudentById(student);
        closeSqlSession(sqlSession);
        return studentById;
    }

    /**
     * 添加学生
     *
     * @param student
     * @throws SQLException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 14:49 2019-07-22/0022
     */
    @Override
    public boolean addStudent(Student student) throws SQLException, IOException {
        if (checkEmail(student.getEmail())) {
            log.info("Email Right!!!");
            if (checkPhone(student.getPhone())) {
                log.info("Phone Number Right!!!");
                //studentDao.addStudent(student);
                SqlSession sqlSession = MybatisUtil.initMybatis();
                StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
                mapper.addStudent(student);
                closeSqlSession(sqlSession);
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
     * @throws IOException
     * @author Fcscanf
     * @date 下午 15:38 2019-07-22/0022
     */
    @Override
    public boolean updateStudent(Student student) throws SQLException, IOException {
        if (checkEmail(student.getEmail())) {
            log.info("Email Right!!!");
            if (checkPhone(student.getPhone())) {
                log.info("Phone Number Right!!!");
                //studentDao.updateStudent(student);
                SqlSession sqlSession = MybatisUtil.initMybatis();
                StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
                mapper.updateStudent(student);
                closeSqlSession(sqlSession);
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
     * @return List<Student>
     * @throws SQLException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    @Override
    public List<Student> selectAllStudent() throws SQLException, IOException {
        //return studentDao.selectAllStudent();
        SqlSession sqlSession = MybatisUtil.initMybatis();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAllStudent();
        closeSqlSession(sqlSession);
        return students;
    }

    /**
     * 模糊查询
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @throws IOException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    @Override
    public List<Student> likeSelectStudent(Student student) throws SQLException, IOException {
        //return studentDao.likeSelectStudent(student);
        SqlSession sqlSession = MybatisUtil.initMybatis();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        if (!(student.getId() == 0)) {
            List<Student> students = mapper.likeSelectStudentById(student);
            closeSqlSession(sqlSession);
            return students;
        } else if (!student.getName().isEmpty()) {
            List<Student> students = mapper.likeSelectStudentByName(student);
            closeSqlSession(sqlSession);
            return students;
        } else if (!student.getEmail().isEmpty()) {
            List<Student> students = mapper.likeSelectStudentByEmail(student);
            closeSqlSession(sqlSession);
            return students;
        } else if (!student.getPhone().isEmpty()) {
            List<Student> students = mapper.likeSelectStudentByPhone(student);
            closeSqlSession(sqlSession);
            return students;
        } else {
            List<Student> students = mapper.likeSelectStudentByQq(student);
            closeSqlSession(sqlSession);
            return students;
        }
    }

    /**
     * 分页查询数据
     *
     * @param page
     * @return List<Student>
     * @throws SQLException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 18:24 2019-07-23/0023
     */
    @Override
    public List<Student> pageQueryStudent(Page page) throws SQLException, IOException {
        //return studentDao.pageQueryStudent(page);
        SqlSession sqlSession = MybatisUtil.initMybatis();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.pageQueryStudent(page);
        closeSqlSession(sqlSession);
        return students;
    }

    /**
     * 删除学生
     *
     * @param student
     * @return int
     * @throws SQLException
     * @throws IOException
     * @author Fcscanf
     * @date 上午 11:31 2019-07-24/0024
     */
    @Override
    public int deleteStu(Student student) throws SQLException, IOException {
        //return studentDao.deleteStu(student);
        SqlSession sqlSession = MybatisUtil.initMybatis();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int i = mapper.deleteStu(student);
        closeSqlSession(sqlSession);
        return i;
    }

    /**
     * 查询表的总条目数
     *
     * @return int
     * @throws SQLException
     * @throws IOException
     * @author Fcscanf
     * @date 下午 15:30 2019-07-24/0024
     */
    @Override
    public int tableTotal() throws SQLException, IOException {
        //return studentDao.tableTotal();
        SqlSession sqlSession = MybatisUtil.initMybatis();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        int tableTotal = mapper.tableTotal();
        closeSqlSession(sqlSession);
        return tableTotal;
    }

    /**
     * 校验邮箱
     *
     * @param email
     * @return true
     * 校验通过返回true
     * 校验失败返回false
     * @author Fcscanf
     * @date 下午 17:10 2019-07-22/0022
     */
    public boolean checkEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$" , email);
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
        return Pattern.matches("^((1[0-9][0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$" , phone);
    }

    /**
     * 提交以及关闭SqlSession
     *
     * @param sqlSession
     * @author Fcscanf
     * @date 下午 19:05 2019-07-25/0025
     */
    public void closeSqlSession(SqlSession sqlSession) {
        sqlSession.commit();
        sqlSession.close();
    }
}
