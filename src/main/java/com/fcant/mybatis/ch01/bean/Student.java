package com.fcant.mybatis.ch01.bean;

import lombok.Data;

/**
 * Student
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 22:59 2019-07-24/0024
 */
@Data
public class Student {
    // 定义属性，和student表中的字段对应
    /**
     * id===>s_id
     */
    private int id;

    /**
     * name===>s_name
     */
    private String name;
}
