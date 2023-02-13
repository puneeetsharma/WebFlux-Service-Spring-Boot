package com.example.JavaFluxProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {WebMvcAutoConfiguration.class })
@EnableSwagger2
public class JavaFluxProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFluxProjectApplication.class, args);
	}

}
