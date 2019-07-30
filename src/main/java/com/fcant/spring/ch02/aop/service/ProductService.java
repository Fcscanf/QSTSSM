package com.fcant.spring.ch02.aop.service;

import org.springframework.stereotype.Component;

/**
 * ProductService
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 18:39 2019-07-30/0030
 */
@Component("s")
public class ProductService {
    public void doSomeService() {
        String str = "";
        for (int i = 0; i < 1000; i++) {
            str += i;
        }
        System.out.println("doSomeService:" + str);
    }
}
