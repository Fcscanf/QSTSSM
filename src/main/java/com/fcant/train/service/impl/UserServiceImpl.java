package com.fcant.train.service.impl;

import com.fcant.train.bean.User;
import com.fcant.train.dao.UserDao;
import com.fcant.train.dao.impl.UserDaoImpl;
import com.fcant.train.service.UserService;

import java.sql.SQLException;

/**
 * UserServiceImpl
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 10:40 2019-07-22/0022
 */
public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    /**
     * 查找用户
     *
     * @param username
     * @return user
     * @author Fcscanf
     * @date 上午 10:35 2019-07-22/0022
     */
    @Override
    public User findUser(String username) throws SQLException {
        return userDao.findUser(username);
    }

    /**
     * 校验用户-用户名正确以及密码正确返回true
     *
     * @param user
     * @return boolean
     * @author Fcscanf
     * @date 上午 10:35 2019-07-22/0022
     */
    @Override
    public boolean checkUser(User user) throws SQLException {
        User findUser = findUser(user.getUname());
        if (findUser.getPassword().equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 添加用户
     *
     * @param user
     * @throws SQLException
     * @author Fcscanf
     * @date 下午 14:25 2019-07-22/0022
     */
    @Override
    public void addUser(User user) throws SQLException {
        userDao.addUser(user);
    }
}
