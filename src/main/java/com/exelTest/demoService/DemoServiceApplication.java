package com.exelTest.demoService;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exelTest.demoService.services.UserService;

@SpringBootApplication
public class DemoServiceApplication implements CommandLineRunner {
	
	
	@Value("${spring.boot.tutorial.var1}")
	String var1;
	
	@Autowired
	private UserService ser;

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server started on port : 2009");
		String path = var1;
		FileInputStream fileInputStream = new FileInputStream(new File(path));
		this.ser.saveFile(fileInputStream);
	}

}
