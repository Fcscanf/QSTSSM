package com.fcant.train.utils;

import com.fcant.train.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

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
    public static SqlSession initMybatis() throws IOException {
        // mybatis的配置文件
        String resource = "train/mybatis-config.xml";
        // 使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        //InputStream reader = MybatisUtil.class.getClassLoader().getResourceAsStream(resource);
        // 构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        // 构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        // 创建能执行映射文件中sql的sqlSession
        return sessionFactory.openSession();
    }

    public static void userMapperFind (SqlSession sqlSession) {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.findUser("Fcant"));
    }
}
