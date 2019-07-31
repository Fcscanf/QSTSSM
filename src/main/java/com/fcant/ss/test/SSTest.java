package com.fcant.ss.test;

import com.fcant.ss.bean.Product;
import com.fcant.ss.mapper.ProductMapper;
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
@ContextConfiguration("classpath:ss/applicationContext.xml")
public class SSTest {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void productMapperTest() {
        Product product = new Product();
        product.setpName("惠普电脑");
        product.setpType("HP-ENVY");
        product.setpAddress("北京太和");
        int insert = productMapper.insert(product);
        System.out.println("成功插入 " + insert + " 条数据");
    }
}
