package com.fcant.mybatis.ch01.bean;

import lombok.Data;

/**
 * Teacher
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 22:34 2019-07-24/0024
 */
@Data
public class Teacher {
    // 定义实体类的属性，与teacher表中的字段对应
    /**
     * id===>t_id
     */
    private int id;

    /**
     * name===>t_name
     */
    private String name;
}
