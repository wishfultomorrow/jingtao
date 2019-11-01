package com.jt.mapper;


import java.util.List;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jt.pojo.User;
/**
 * 代理方式:
 * 1.JDK代理    默认配置         
 * 2.CGLIB代理
 * spring原理自动实现
 *  1.如果代理者是接口默认采用JDK代理 
 *   JDK代理必须要有接口
 *  2.如果代理者没有接口(没有实现接口)默认采用CGLIB
 *  规定:可以创建任何对象的代理,代理者是目标文件的子类
 * @author Administrator
 *
 */
//@Mapper//将接口交于spring管理     管理UserMapper代理对象

public interface UserMapper extends BaseMapper<User>{

	List<User> findAll();
}
