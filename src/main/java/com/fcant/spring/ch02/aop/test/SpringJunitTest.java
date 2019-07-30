package com.fcant.spring.ch02.aop.test;

import com.fcant.spring.ch01.di_ioc.bean.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * SpringJunitTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 18:56 2019-07-30/0030
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/ch01/applicationContext.xml")
public class SpringJunitTest {
    @Autowired
    Category c;

    @Test
    public void test() {
        System.out.println(c.getName());
    }
}
