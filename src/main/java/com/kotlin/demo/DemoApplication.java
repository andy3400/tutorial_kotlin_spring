package com.kotlin.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	// Java에 비해 세미콜론 필요 없음, 빈 클래스에 대괄호도 없음.
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
