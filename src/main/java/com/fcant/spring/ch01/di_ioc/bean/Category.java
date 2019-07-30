package com.fcant.spring.ch01.di_ioc.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Category
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 20:51 2019-07-29/0029
 */
@Data
@Component("c")
public class Category {
    private int id;
    private String name = "category 1";
}
