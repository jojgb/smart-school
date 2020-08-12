package com.example.smartspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.smartspring.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
	
	@Query("SELECT U.username FROM UserModel U")
	List<UserModel> cariUsername();
	
	@Query("SELECT U.password from UserModel U")
	List<UserModel> cariPassword();
}
