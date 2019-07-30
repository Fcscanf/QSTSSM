package com.fcant.spring.ch02.aop.test;

import com.fcant.spring.ch02.aop.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * SpringTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 20:53 2019-07-29/0029
 */
public class SpringAopTest {
    public static void main(String[] args) {
        // 读取applicationContext.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/ch02/applicationContext.xml"});
        ProductService s = (ProductService)context.getBean("s");
        s.doSomeService();
    }
}
