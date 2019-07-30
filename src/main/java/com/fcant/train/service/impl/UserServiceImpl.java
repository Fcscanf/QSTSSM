package com.fcant.train.service.impl;

import com.fcant.train.bean.User;
import com.fcant.train.dao.UserDao;
import com.fcant.train.dao.impl.UserDaoImpl;
import com.fcant.train.mapper.UserMapper;
import com.fcant.train.service.UserService;
import com.fcant.train.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
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
    public User findUser(String username) throws SQLException, IOException {
        //return userDao.findUser(username);
        SqlSession sqlSession = MybatisUtil.initMybatis();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUser(username);
        closeSqlSession(sqlSession);
        return user;
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
    public boolean checkUser(User user) throws SQLException, IOException {
        User findUser = findUser(user.getUname());
        if (findUser == null) {
            return false;
        } else if (findUser.getPassword().equals(user.getPassword())) {
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
    public void addUser(User user) throws SQLException, IOException {
        //userDao.addUser(user);
        SqlSession sqlSession = MybatisUtil.initMybatis();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(user);
        closeSqlSession(sqlSession);
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
