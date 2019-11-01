package com.example.demo.hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@PropertySource(value = { "classpath:/properties/jdbc.properties" })
@RestController
//多个property文件路径的加载
//@PropertySources(value = { @PropertySource("classpath:/properties/jdbc.properties") 
//})
public class HelloController {
	@Value("${jdbc.jdbcurl}")
	private String jdbc;
	@Value("${jdbc.name}")
	private String username;
	
	
	
	@RequestMapping("/getjdbc")
	public String getjdbc() {
		String smg="开发环境:"; 
		smg=":"+jdbc+":"+username;
		return smg;
	}
	
}
