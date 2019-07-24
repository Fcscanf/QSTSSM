package com.fcant.mybatis.ch01.mapper;

import com.fcant.mybatis.ch01.bean.User;

import java.util.List;

/**
 * UserMapper
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 17:10 2019-07-24/0024
 */
public interface UserMapper {
    /**
     * 增加
     *
     * @param user
     * @return int
     */
    public int add(User user);

    /**
     * 删除
     *
     * @param id
     * @return int
     */
    public int deleteById(int id);

    /**
     * 更新
     *
     * @param user
     * @return int
     */
    public int update(User user);

    /**
     * 根据id查询用户
     *
     * @param id
     * @return User
     */
    public User getById(int id);

    /**
     * 查询所有用户
     *
     * @return List<User>
     */
    public List<User> getAll();
}
