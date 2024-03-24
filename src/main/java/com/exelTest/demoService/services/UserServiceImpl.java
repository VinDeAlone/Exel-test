package com.exelTest.demoService.services;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.exelTest.demoService.entities.User;
import com.exelTest.demoService.helpers.UserHelper;
import com.exelTest.demoService.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repo;

	@Override
	public void saveFile(FileInputStream fileInputStream) {
		List<User> users =  UserHelper.convertExelDataToListOfUsers(fileInputStream);
		this.repo.saveAll(users);
	}

	@Override
	public List<User> getAllUsers() {
		return this.repo.findAll();
	}

	@Override
	public void save(User user) {
		this.repo.save(user);
	}

}
