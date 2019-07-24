package com.fcant.mybatis.ch01.mapper;

import com.fcant.mybatis.ch01.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * UserMapperAnno
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 19:28 2019-07-24/0024
 */
public interface UserMapperAnno {

    /**
     * 增加
     *
     * @param user
     * @return int
     */
    @Insert("insert into m_users(name, age) values(#{name}, #{age})")
    public int add(User user);

    /**
     * 删除
     *
     * @param id
     * @return int
     */
    @Delete("delete from m_users where id=#{id}")
    public int deleteById(int id);

    /**
     * 更新
     *
     * @param user
     * @return int
     */
    @Update("update m_users set name=#{name},age=#{age} where id=#{id}")
    public int update(User user);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return User
     */
    @Select("select * from m_users where id=#{id}")
    public User getById(int id);

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    @Select("select * from m_users")
    public List<User> getAll();
}
