package com.fcant.train.service;

import com.fcant.train.bean.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * UserService
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 10:28 2019-07-22/0022
 */
public interface UserService {

    /**
     * 查找用户
     *
     * @param username
     * @return user
     * @exception SQLException
     * @author Fcscanf
     * @date 上午 10:35 2019-07-22/0022
     */
    public User findUser(String username) throws SQLException, IOException;

    /**
     * 校验用户:用户名正确以及密码正确返回true
     *
     * @param user
     * @return boolean
     * @exception SQLException
     * @author Fcscanf
     * @date 上午 10:35 2019-07-22/0022
     */
    public boolean checkUser(User user) throws SQLException, IOException;

    /**
     * 添加用户
     *
     * @param user
     * @exception SQLException
     * @author Fcscanf
     * @date 下午 14:25 2019-07-22/0022
     */
    public void addUser(User user) throws SQLException, IOException;
}
