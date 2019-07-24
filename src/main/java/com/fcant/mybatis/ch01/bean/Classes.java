package com.fcant.mybatis.ch01.bean;

import lombok.Data;

import java.util.List;

/**
 * Classes
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 22:35 2019-07-24/0024
 */
@Data
public class Classes {
    // 定义实体类的属性，与class表中的字段对应
    /**
     * id===>c_id
     */
    private int id;

    /**
     * name===>c_name
     */
    private String name;

    /**
     * class表中有一个teacher_id字段，所以在Classes类中定义一个teacher属性，
     * 用于维护teacher和class之间的一对一关系，通过这个teacher属性就可以知道这个班级是由哪个老师负责的
     */
    private Teacher teacher;

    /**
     * 使用一个List<Student>集合属性表示班级拥有的学生
     */
    private List<Student> students;
}
