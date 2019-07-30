package com.fcant.train.mapper;

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
public interface StudentMapper {

    /**
     * 根据姓名查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    public Student findStudentByName(Student student);

    /**
     * 根据Id查找学生
     *
     * @param student
     * @return student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:48 2019-07-22/0022
     */
    public Student findStudentById(Student student);

    /**
     * 添加学生
     *
     * @param student
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:49 2019-07-22/0022
     */
    public void addStudent(Student student);

    /**
     * 更新学生信息
     *
     * @param student
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 15:38 2019-07-22/0022
     */
    public int updateStudent(Student student);

    /**
     * 查询所有学生信息
     *
     * @return
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 20:30 2019-07-22/0022
     */
    public List<Student> selectAllStudent();

    /**
     * 根据类属性进行进行Mybatis的动态SQL查询
     *
     * @param student
     * @return List<Student>
     * @author Fcscanf
     * @date 上午 9:09 2019-07-30/0030 
     */
    public List<Student> likeSelectByIF(Student student);

    /**
     * 模糊查询-根据学生ID
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudentById(Student student);

    /**
     * 模糊查询-根据学生Name
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudentByName(Student student);

    /**
     * 模糊查询-根据学生邮箱
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudentByEmail(Student student);

    /**
     * 模糊查询-根据学生手机
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudentByPhone(Student student);

    /**
     * 模糊查询-根据学生QQ
     *
     * @param student
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:45 2019-07-23/0023
     */
    public List<Student> likeSelectStudentByQq(Student student);

    /**
     * 分页查询数据
     *
     * @param page
     * @return List<Student>
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 18:24 2019-07-23/0023
     */
    public List<Student> pageQueryStudent(Page page);

    /**
     * 删除学生
     *
     * @param student
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 上午 11:31 2019-07-24/0024
     */
    public int deleteStu(Student student);

    /**
     * 学生信息的批量删除
     *
     * @param ids
     * @return int
     * @author Fcscanf
     * @date 上午 10:39 2019-07-30/0030
     */
    public int delStuBatch(List<Integer> ids);

    /**
     * 查询表的总条目数
     *
     * @return int
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 15:30 2019-07-24/0024
     */
    public int tableTotal();
}
