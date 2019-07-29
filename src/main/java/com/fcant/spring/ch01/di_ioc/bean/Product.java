package com.fcant.spring.ch01.di_ioc.bean;

import lombok.Data;

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
public class Product {
    private int id;
    private String name;
    private int number;
    private double price;
    private Category category;
}
