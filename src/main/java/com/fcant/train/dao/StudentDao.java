package com.fcant.train.dao;

import com.fcant.train.bean.Page;
import com.fcant.train.bean.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * StudentDao
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 14:46 2019-07-22/0022
 */
public interface StudentDao {

    /**
     * 根据姓名查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    public Student findStudentByName(Student student) throws SQLException;

    /**
     * 根据Id查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    public Student findStudentById(Student student) throws SQLException;

    /**
     * 添加学生
     *
     * @param student
     * @throws  SQLException
     * @author Fcscanf
     * @date 下午 14:49 2019-07-22/0022
     */
    public void addStudent(Student student) throws SQLException;

    /**
     * 更新学生信息
     *
     * @param student
     * @return int
     * @throws  SQLException
     * @author Fcscanf
     * @date 下午 15:38 2019-07-22/0022
     */
    public int updateStudent(Student student) throws SQLException;

    /**
     * 查询所有学生信息
     *
     * @return
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    public List<Student> selectAllStudent() throws SQLException;

    /**
     * 模糊查询
     *
     * @param student
     * @throws SQLException
     * @return List<Student>
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudent(Student student) throws SQLException;

    /**
     * 分页查询数据
     *
     * @param page
     * @throws SQLException
     * @return List<Student>
     * @author Fcscanf
     * @date 下午 18:24 2019-07-23/0023
     */
    public List<Student> pageQueryStudent(Page page) throws SQLException;

    /**
     * 删除学生
     *
     * @param student
     * @throws SQLException
     * @return int
     * @author Fcscanf
     * @date 上午 11:31 2019-07-24/0024
     */
    public int deleteStu(Student student) throws SQLException;
}
