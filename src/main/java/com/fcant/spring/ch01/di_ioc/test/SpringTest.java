package com.fcant.spring.ch01.di_ioc.test;

import com.fcant.spring.ch01.di_ioc.bean.Category;
import com.fcant.spring.ch01.di_ioc.bean.Product;
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
public class SpringTest {
    public static void main(String[] args) {
        // 读取applicationContext.xml配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/ch01/applicationContext.xml"});
        // 在xml文件中，bean标签的name是c，获取到name为c的bean标签里面的内容强转为Category类型
        Category c = (Category) context.getBean("c");
        System.out.println(c.getName());
        Product product = (Product) context.getBean("product");
        System.out.println(product);
    }
}
