package com.fcant.mybatis.ch01;

import com.fcant.mybatis.ch01.bean.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * MybatisTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 16:43 2019-07-24/0024
 */
public class MybatisTest {
    public static void main(String[] args) {
        // mybatis的配置文件
        String resource = "mybatis/ch01/mybatis.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();


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
