package com.fcant.mybatis.ch01.test;

import org.apache.ibatis.session.SqlSession;

/**
 * MainTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 17:23 2019-07-24/0024
 */
public class MainTest {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtil.initMybatis();
        //MybatisUtil.mybatisOneTest(sqlSession);
        MybatisUtil.testMapper(sqlSession);
    }
}
