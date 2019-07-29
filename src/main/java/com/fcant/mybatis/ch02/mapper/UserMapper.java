package com.fcant.mybatis.ch02.mapper;

import com.fcant.mybatis.ch02.bean.User;

import java.util.List;

/**
 * UserMapper
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 18:47 2019-07-29/0029
 */
public interface UserMapper {

    /**
     * 根据ID获取用户
     * @param uid
     * @return User
     */
    public User selectUserById(Integer uid);

    /**
     * 获取所有用户
     * @return List<User>
     */
    public List<User> selectAllUser();

    /**
     * 添加用户
     * @param user
     * @return int
     */
    public int addUser(User user);

    /**
     * 更新用户
     * @param user
     * @return int
     */
    public int updateUser(User user);

    /**
     * 删除用户
     * @param uid
     * @return int
     */
    public int deleteUser(Integer uid);


    /**
     * 根据if条件查询用户
     * @param user
     * @return List<User>
     */
    public List<User> selectUserByIf(User user);

    /**
     * 根据选择条件查询用户
     *
     * @param user
     * @return List<User>
     * @author Fcscanf
     * @date 下午 18:55 2019-07-29/0029 
     */
    public List<User> selectUserByChoose(User user);

    /**
     * 根据trim查询用户
     *
     * @param user
     * @return List<User>
     * @author Fcscanf
     * @date 下午 18:57 2019-07-29/0029
     */
    public List<User> selectUserByTrim(User user);

    /**
     * 根据where条件查询用户
     *
     * @param user
     * @return List<User>
     * @author Fcscanf
     * @date 下午 18:58 2019-07-29/0029
     */
    public List<User> selectUserByWhere(User user);

    /**
     * 根据set更新用户信息
     *
     * @param user
     * @return int
     * @author Fcscanf
     * @date 下午 18:58 2019-07-29/0029
     */
    public int updateUserBySet(User user);

    /**
     * 根据ID批量查询用户
     *
     * @param listId
     * @return List<User>
     * @author Fcscanf
     * @date 下午 18:59 2019-07-29/0029
     */
    public List<User> selectUserByForeach(List<Integer> listId);

    /**
     * 根据bind查询用户
     *
     * @param user
     * @return List<User>
     * @author Fcscanf
     * @date 下午 18:59 2019-07-29/0029
     */
    public List<User> selectUserByBind(User user);
}
