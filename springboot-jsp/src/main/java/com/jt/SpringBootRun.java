package com.jt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jt.mapper")//将mapper文件扫描交于主启动类管理
public class SpringBootRun {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRun.class);
	}
}
