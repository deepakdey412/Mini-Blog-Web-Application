package com.deepak.mini_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class MiniBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniBlogApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer configurerCROS(){
		return new WebMvcConfigurer() {
			public  void addCORSMapping(CorsRegistry registry){
				registry.addMapping("/**").allowedOrigins("http://localhost:5173");
			}
		};
	}

}
