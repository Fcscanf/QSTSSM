package com.fcant.train.service;

import com.fcant.train.bean.Page;
import com.fcant.train.bean.Student;

import java.io.IOException;
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
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    public Student findStudent(Student student) throws SQLException, IOException;

    /**
     * 添加学生
     *
     * @param student
     * @return true
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:49 2019-07-22/0022
     */
    public boolean addStudent(Student student) throws SQLException, IOException;

    /**
     * 更新学生信息
     *
     * @param student
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 15:38 2019-07-22/0022
     */
    public boolean updateStudent(Student student) throws SQLException, IOException;

    /**
     * 查询所有学生信息
     *
     * @return
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    public List<Student> selectAllStudent() throws SQLException, IOException;

    /**
     * 模糊查询
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudent(Student student) throws SQLException, IOException;

    /**
     * 分页查询数据
     *
     * @param page
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 18:24 2019-07-23/0023
     */
    public List<Student> pageQueryStudent(Page page) throws SQLException, IOException;

    /**
     * 删除学生
     *
     * @param student
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:31 2019-07-24/0024
     */
    public int deleteStu(Student student) throws SQLException, IOException;

    /**
     * 学生信息的批量删除
     *
     * @param ids
     * @return int
     * @throws IOException
     * @author Fcscanf
     * @date 上午 10:39 2019-07-30/0030
     */
    public int delStuBatch(List<Integer> ids) throws IOException;

    /**
     * 查询表的总条目数
     *
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 15:30 2019-07-24/0024
     */
    public int tableTotal() throws SQLException, IOException;
}
