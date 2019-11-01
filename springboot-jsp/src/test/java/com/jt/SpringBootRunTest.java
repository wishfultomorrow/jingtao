package com.jt;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.jt.mapper.UserMapper;
import com.jt.pojo.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRunTest {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void testFindUser() {
		System.out.println(userMapper.getClass());
		//System.out.println(userMapper.findAll());
		List<User> userList = userMapper.selectList(null);//为空表示查询全部的数据库
		System.out.println(userList);
	}
	@Test
	public void testInsert() {
		User user = new User();
		//男   刀   @警察   3天
		user.setName("韩美娟");
		user.setAge(40);
		user.setSex("其他");
		userMapper.insert(user);
		System.out.println("入库成功");
	}
	@Test
	public void testDel() {
		//单个删除
		//userMapper.deleteById(54);
		//批量删除
		List<Integer> IdList=new ArrayList();
		IdList.add(54);
		IdList.add(55);
		userMapper.deleteBatchIds(IdList);
	}
	/**
	 * 要求将53号元素的性别改为男
	 */
	@Test
	public void testUpdate() {
		User user = new User();
		user.setSex("男");
		user.setId(53);
		//根据对象中不为null的属性进行操作
		userMapper.updateById(user);
	}
	/*将name为null的数据改为name为苏乞儿*/
	@Test
	public void testUpdate2() {
		User user = new User();
		user.setName("苏乞儿");
		UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
		updateWrapper.isNull("name");
		userMapper.update(user, updateWrapper);
		System.out.println("恭喜你");
		
	}
	
	//1.查询id为52号的元素
	//2.查询名称为如花的数据 name="如花"
	//queryWrapper条件构造器
	//动态生成where条件之后的sql
	@Test
	public void testSelectOne() {
		//User user = userMapper.selectById(52);
		User user = new User();
		user.setName("如花");
		QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
		//根据其中不为空的属性,当做where条件
		User userdb = userMapper.selectOne(queryWrapper);
		System.out.println(userdb);
	}
	
	//查询name如花andage=17的结果
	@Test
	public void testselectList1() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("name", "如花").eq("age", 17);
		User userdb = userMapper.selectOne(queryWrapper);
		System.out.println(userdb);
	}
	
	//1.查询年龄大于100岁的人    >gt    <lt =eq     
	//2.查询age大于100或者小于18
	//3.查询大于17到小于100的数据
	//4.查询 name为null的数据
	/*
	 * entity:要修改后的数据信息
	 * */
	
	@Test
	public void testSelectList2() {
		QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//		queryWrapper.gt("age", 100);
//		List<User> user = userMapper.selectList(queryWrapper);
		//queryWrapper.gt("age", 100).or().lt("age", 17);
//		queryWrapper.between("age", 18, 100);
		queryWrapper.isNull("name");
		List<User> user = userMapper.selectList(queryWrapper);
		
		System.out.println(user);
	}
	
}
