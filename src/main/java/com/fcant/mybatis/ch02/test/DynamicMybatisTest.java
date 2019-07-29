package com.fcant.mybatis.ch02.test;

import com.fcant.mybatis.ch02.bean.User;
import com.fcant.mybatis.ch02.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * DynamicMybatisTest
 * <p>
 * encoding:UTF-8
 *
 * @author Fcscanf
 * @description
 * @date 下午 19:16 2019-07-29/0029
 */
public class DynamicMybatisTest {
    public static void main(String[] args) {
        SqlSession session = MybatisUtil.initMybatis();
        // 通过getMapper()方法获取ClassMapper接口
        UserMapper userMapper = session.getMapper(UserMapper.class);

        // 查询一个用户
		/*User auser = userMapper.selectUserById(1);
		System.out.println(auser);
		System.out.println("================");*/

		// 添加一个用户
		/*User addmu = new User();
		addmu.setName("小智");
		addmu.setSex("男");
		int add = userMapper.addUser(addmu);
		System.out.println("添加了" + add + "条记录");
		System.out.println("================");*/

		// 修改一个用户
		/*User updatemu = new User();
		updatemu.setId(1);
		updatemu.setName("小兰");
		updatemu.setSex("女");
		int up = userMapper.updateUser(updatemu);
		System.out.println("修改了" + up + "条记录");
		System.out.println("================");*/

		// 删除一个用户
		/*int dl = userMapper.deleteUser(1);
		System.out.println("删除了" + dl + "条记录");
		System.out.println("================");*/

		// 查询所有用户
		/*List<User> list = userMapper.selectAllUser();
		for (User myUser : list) {
			System.out.println(myUser);
		}*/

		// 使用if元素查询用户信息
		/*User ifmu = new User();
		ifmu.setName("小");
		ifmu.setSex("女");
		List<User> listByif = userMapper.selectUserByIf(ifmu);
		System.out.println("if元素================");
		for (User myUser : listByif) {
			System.out.println(myUser);
		}*/

		// 使用choose元素查询用户信息
		/*User choosemu = new User();
		choosemu.setName("小");
		choosemu.setSex("女");
		List<User> listByChoose = userMapper.selectUserByChoose(choosemu);
		System.out.println("choose元素================");
		for (User myUser : listByChoose) {
			System.out.println(myUser);
		}*/

        // 使用trim元素查询用户信息
        /*User trimmu = new User();
        trimmu.setName("小");
        trimmu.setSex("男");
        List<User> listByTrim = userMapper.selectUserByTrim(trimmu);
        System.out.println("trim元素================");
        for (User myUser : listByTrim) {
            System.out.println(myUser);
        }*/

        // 使用where元素查询用户信息
        /*User wheremu = new User();
        wheremu.setName("小");
        wheremu.setSex("男");
        List<User> listByWhere = userMapper.selectUserByWhere(wheremu);
        System.out.println("where元素================");
        for (User myUser : listByWhere) {
            System.out.println(myUser);
        }*/

        // 使用set元素修改一个用户
        /*User setmu = new User();
        setmu.setId(6);
        setmu.setName("张起灵");
        int setup = userMapper.updateUserBySet(setmu);
        System.out.println("set元素修改了" + setup + "条记录");
        System.out.println("================");*/

        // 使用foreach元素，查询用户信息
        /*List<Integer> listId = new ArrayList<Integer>();
        listId.add(4);
        listId.add(6);
        List<User> listByForeach = userMapper.selectUserByForeach(listId);
        System.out.println("foreach元素================");
        for (User myUser : listByForeach) {
            System.out.println(myUser);
        }*/

        // 使用bind元素查询用户信息
        User bindmu = new User();
        bindmu.setName("小");
        List<User> listByBind = userMapper.selectUserByBind(bindmu);
        System.out.println("bind元素================");
        for (User myUser : listByBind) {
            System.out.println(myUser);
        }

        session.commit();

        // 使用SqlSession执行完SQL之后需要关闭SqlSession
        session.close();
    }
}
