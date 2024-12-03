package com.myProject.RestaurantProject.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myProject.RestaurantProject.Dto.RoleDto;
import com.myProject.RestaurantProject.Dto.UserDto;
import com.myProject.RestaurantProject.Entities.UserEntities;
import com.myProject.RestaurantProject.Payload.ResponseData;
import com.myProject.RestaurantProject.Payload.Request.SignupRequest;
import com.myProject.RestaurantProject.Repository.UserRepository;
import com.myProject.RestaurantProject.Service.LoginService;
import com.myProject.RestaurantProject.Service.Impl.LoginServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	@PostMapping("/signin")
	public ResponseEntity<?> signin(@RequestParam String username, String password){
		ResponseData responseData = new ResponseData();
		if(loginServiceImpl.checkLogin(username, password)) {
			responseData.setData(true);
		}
		else {
			responseData.setData(false);
		}
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
		ResponseData responseData = new ResponseData();
		responseData.setData(loginServiceImpl.addUser(signupRequest));
		return new ResponseEntity<>(responseData, HttpStatus.OK);
	}
	
//	@GetMapping("/getalluser")
//	public ResponseEntity<?> getAllUser(){
//		ResponseData responseData = new ResponseData();
//		responseData.setData(loginServiceImpl.getAllUser());
//		return new ResponseEntity<>(responseData, HttpStatus.OK);
//	}
}
