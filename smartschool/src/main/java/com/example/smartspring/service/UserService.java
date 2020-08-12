package com.example.smartspring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.smartspring.model.UserModel;
import com.example.smartspring.repository.UserRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
@Transactional
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(UserModel userModel) {
		this.userRepository.save(userModel);
	}
	
	public List<UserModel> readUser() {
		return this.userRepository.findAll();
	}
	
	public List<UserModel> cariUsername() {
		return this.userRepository.cariUsername();
	}
	
	public List<UserModel> cariPassword() {
		return this.userRepository.cariPassword();
	}
}
