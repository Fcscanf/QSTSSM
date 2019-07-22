package com.fcant.train.dao.impl;

import com.fcant.train.bean.User;
import com.fcant.train.dao.UserDao;
import com.fcant.train.utils.JDBCUtils;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * UserDaoImpl
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 10:39 2019-07-22/0022
 */
@Slf4j
public class UserDaoImpl implements UserDao {

    Connection connection = JDBCUtils.getConnection();

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
        User user = new User();
        String sql = "SELECT * from t_user u where u.uname=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            user.setUid(resultSet.getInt(1));
            user.setUname(resultSet.getString(2));
            user.setPassword(resultSet.getString(3));
            log.info(user.toString());
            log.info("ID : " + resultSet.getInt(1) + "--->>>  Name : " + resultSet.getString(2) + "--->>>  Password : " + resultSet.getString(3));
        }
        return user;
    }

    /**
     * 添加用户
     *
     * @param user
     * @author Fcscanf
     * @date 下午 14:25 2019-07-22/0022
     */
    @Override
    public void addUser(User user) throws SQLException {
        String sql = "insert into t_user(uname, password) values (?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, user.getUname());
        statement.setString(2, user.getPassword());
        int i = statement.executeUpdate();
        log.info("Add User : " + user.toString());
    }
}
