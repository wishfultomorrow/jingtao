package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//批量赋值
@ConfigurationProperties(prefix="jdbc")
public class JdbcController {

//	@Value("${user.username}")
//		private String name;
//	
	private String jdbcUrl;

	private String username;

	private String password;
	
	

	public String getJdbcUrl() {
		return jdbcUrl;
	}



	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}


//注解赋值
	//	@Value("${user.name}")
	//	private String username1;
	//	@Value("${jdbc.jdbcUrl}")
	//	private String jdbcUrl;
	//	@Value("${jdbc.username}")
	//	private String username;
	//	@Value("${jdbc.password}")
	//	private String password;
	//	@Value("${user.name}")
	//	private String username1;
	@RequestMapping("/getConn")
	public String getConn() {
		String msg="获取数据库连接";
		msg=":"+jdbcUrl+":"+username+":"+password;
		return msg;
	}
}
