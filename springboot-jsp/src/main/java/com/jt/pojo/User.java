package com.jt.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

//ORM
@Data
@Accessors(chain=true)//链式编程
@TableName//如果表明与类名名字一直value可以省略@TableName(value="表名")
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7608936516759666971L;
	@TableId(type = IdType.AUTO)//主键自增表示
	private Integer id;
	//如果字段属性名称一致,可省略配置
	//@TableField(value="name")若不一致添加此注释将name只赋予字段中的name
	private String name;
	private Integer age;
	private String sex;
}
