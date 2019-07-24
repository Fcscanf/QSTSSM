package com.fcant.mybatis.ch01.test;

import com.fcant.mybatis.ch01.bean.User;
import com.fcant.mybatis.ch01.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * MybatisTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 16:43 2019-07-24/0024
 */
public class MybatisUtil {

    /**
     * Mybatis通过输入流获取配置文件SqlSessionFactory
     *
     * @return session
     * @author Fcscanf
     * @date 下午 17:20 2019-07-24/0024
     */
    public static SqlSession initMybatis() {
        // mybatis的配置文件
        String resource = "mybatis/ch01/mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream reader = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        return session;
    }

    public static void testMapper(SqlSession session) {
        // 通过getMapper()方法获取UserMapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = new User();

        /*
        * 新增用户信息
        * **/
        user.setName("test001");
        user.setAge(22);
        userMapper.add(user);

        /*
        * 根据id,查询用户信息
        * **/
        // 执行查询操作，将查询结果自动封装成User返回
        user = userMapper.getById(2);
        System.out.println(user.getName());

        /*
        * 根据id,更新用户信息
        * **/
        user.setId(2);
        user.setName("李四");
        user.setAge(26);
        userMapper.update(user);

        /*
        * 根据id,删除用户信息
        * **/
        userMapper.deleteById(8);

        /*
        * 查询所有的用户
        * **/
        List<User> userList = new ArrayList<User>();
        // 执行查询操作，将查询结果自动封装成List<User>返回
        userList = userMapper.getAll();
        for (User user2 : userList) {
            System.out.println(user2);
        }
        // 增删改操作时，要执行commit操作
        session.commit();
        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        session.close();
    }

    public void testFun(SqlSession session, Object o) {

    }

    /**
     * Mybatis-第一个案例测试
     *
     * @param session
     * @author Fcscanf
     * @date 下午 17:20 2019-07-24/0024
     */
    public static void mybatisOneTest(SqlSession session) {
        /**
         * 映射sql的标识字符串， com.nt.mybatis.mapping.userMapper是userMapper.
         * xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        // 映射sql的标识字符串
        String statement = "com.fcant.mybatis.ch01.mapper.UserMapper.getUser";
        // 执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, 1);
        System.out.println(user);
    }
}
