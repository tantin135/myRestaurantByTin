package com.myProject.RestaurantProject.Service.Impl;

import java.util.List;

import com.myProject.RestaurantProject.Dto.UserDto;
import com.myProject.RestaurantProject.Payload.Request.SignupRequest;

public interface LoginServiceImpl {
	List<UserDto> getAllUser();
	boolean checkLogin(String username, String password);
	boolean addUser(SignupRequest signupRequest);
}
