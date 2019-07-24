package com.fcant.mybatis.ch01.bean;

import lombok.Data;

/**
 * User
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 16:39 2019-07-24/0024
 */
@Data
public class User {
    // 实体表的属性和表的字段名称一一对应
    /**
     * 主键
     */
    private int id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;
}
