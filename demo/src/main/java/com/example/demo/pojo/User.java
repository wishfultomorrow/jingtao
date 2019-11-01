package com.example.demo.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class User {

	private Integer id;
	private String name;
	private Integer sge;
	private String sex;
}
