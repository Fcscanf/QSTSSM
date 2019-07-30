package com.fcant.spring.ch01.di_ioc.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Product
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 20:56 2019-07-29/0029
 */
@Data
@Component("product")
public class Product {
    private int id;
    private String name = "Apple Watch";
    private int number = 2;
    private double price = 8800;
    @Resource(name = "c")
    private Category category;
}
