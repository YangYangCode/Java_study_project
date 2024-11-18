package com.example.demo.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration		// Springboot 在啟動完成前會先執行此配置
public class modelMapperConfig {
	
	// 由 Springboot 來管理此物件 (IOC, 反轉控制)
	// 若有必要，其他程式可以透過 @Autowired 取得該實體
	@Bean	
	// @Scope("singleton")	// 單一實體(預設)
	// @Scope("prototype")	// 多實體 (每個連結者創建一個，避免過載)
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
