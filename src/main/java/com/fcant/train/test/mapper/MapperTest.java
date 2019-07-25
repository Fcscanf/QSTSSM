package com.fcant.train.test.mapper;

import com.fcant.train.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

/**
 * MapperTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 上午 11:24 2019-07-25/0025
 */
public class MapperTest {
    public static void main(String[] args) throws IOException {
        SqlSession sqlSession = MybatisUtil.initMybatis();
        MybatisUtil.userMapperFind(sqlSession);
    }
}
