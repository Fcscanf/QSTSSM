package com.fcant.train.dao;

import com.fcant.train.bean.User;

import java.sql.SQLException;

/**
 * UserDao
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 10:27 2019-07-22/0022
 */
public interface UserDao {

    /**
     * 查找用户
     *
     * @param username
     * @return user
     * @author Fcscanf
     * @date 上午 10:35 2019-07-22/0022
     */
    public User findUser(String username) throws SQLException;

    /**
     * 添加用户
     *
     * @param user
     * @author Fcscanf
     * @date 下午 14:25 2019-07-22/0022
     */
    public void addUser(User user) throws SQLException;
}
