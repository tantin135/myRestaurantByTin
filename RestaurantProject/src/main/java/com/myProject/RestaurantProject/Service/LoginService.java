package com.myProject.RestaurantProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myProject.RestaurantProject.Dto.RoleDto;
import com.myProject.RestaurantProject.Dto.UserDto;
import com.myProject.RestaurantProject.Entities.RoleEntities;
import com.myProject.RestaurantProject.Entities.UserEntities;
import com.myProject.RestaurantProject.Payload.Request.SignupRequest;
import com.myProject.RestaurantProject.Repository.UserRepository;
import com.myProject.RestaurantProject.Service.Impl.LoginServiceImpl;

@Service
public class LoginService implements LoginServiceImpl{
	@Autowired
	UserRepository userRepository; 
	
	@Override
	public List<UserDto> getAllUser(){
		List<UserEntities> listuser = userRepository.findAll();
		List<UserDto> userDtoList = new ArrayList<>();
		for(UserEntities user : listuser) {
			UserDto userDto = new UserDto();
			userDto.setId(user.getId());
			userDto.setFullname(user.getFullname());
			userDto.setDateOfBirth(user.getDateOfBirth());
			userDto.setPhoneNumber(user.getPhoneNumber());
			userDto.setGender(user.isGender());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
			
			//Thêm roleDto để truy xuất role_id
			RoleDto roleDto = new RoleDto();
			roleDto.setRole_id(user.getRoleEntities().getRole_id());
			roleDto.setRole_name(user.getRoleEntities().getRole_name());
			roleDto.setDescription(user.getRoleEntities().getDescription());
			userDto.setRoleDto(roleDto);
			userDtoList.add(userDto);
		}
		return userDtoList;
	}

	@Override
	public boolean checkLogin(String username, String password) {
		List<UserEntities> listUser = userRepository.findByUsernameAndPassword(username, password);
		return listUser.size() > 0;
	}

	@Override
	public boolean addUser(SignupRequest signupRequest) {
		RoleEntities roleEntities = new RoleEntities();
		roleEntities.setRole_id(signupRequest.getRole_id());
		
		UserEntities userentity = new UserEntities();
		userentity.setFullname(signupRequest.getFullname());
		userentity.setDateOfBirth(signupRequest.getDateofbirth());
		userentity.setPhoneNumber(signupRequest.getPhonenumber());
		userentity.setGender(signupRequest.isGender());
		userentity.setUsername(signupRequest.getUsername());
		userentity.setPassword(signupRequest.getPassword());
		userentity.setRoleEntities(roleEntities);
		try {
			userRepository.save(userentity);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
