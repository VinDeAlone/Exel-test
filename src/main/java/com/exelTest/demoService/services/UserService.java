package com.exelTest.demoService.services;

import java.io.FileInputStream;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.exelTest.demoService.entities.User;

public interface UserService {
	
	void save(User user);
	
	void saveFile(FileInputStream fileInputStram);
	
	List<User> getAllUsers();

}
