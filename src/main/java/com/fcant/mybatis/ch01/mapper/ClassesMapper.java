package com.fcant.mybatis.ch01.mapper;

import com.fcant.mybatis.ch01.bean.Classes;

/**
 * ClassesMapper
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 22:39 2019-07-24/0024
 */
public interface ClassesMapper {
    /**
     * 方式一：嵌套结果(根据班级id查询班级信息 )
     *
     * @param id
     * @return
     */
    public Classes getClass(int id);

    /**
     * 方式二：嵌套查询(根据班级id查询班级信息 )
     *
     * @param id
     * @return
     */
    public Classes getClassNest(int id);
}
