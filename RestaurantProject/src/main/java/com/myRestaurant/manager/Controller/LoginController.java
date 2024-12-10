package com.myRestaurant.manager.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myRestaurant.manager.Dto.UserDto;
import com.myRestaurant.manager.Payload.ResponseData;
import com.myRestaurant.manager.Payload.Request.SignupRequest;
import com.myRestaurant.manager.Service.Impl.LoginServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    LoginServiceImpl loginServiceImpl;

    // Phương thức đăng nhập
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestParam String username, String password) {
        ResponseData responseData = new ResponseData();
        if (loginServiceImpl.checkLogin(username, password)) {
            UserDto user = loginServiceImpl.getUserByUsername(username);
            responseData.setData(true);
            responseData.setRole_Id(user.getRoleDto().getRole_id()); // Trả về ID vai trò
            responseData.setDescription(user.getFullname()); // Trả về fullname
        } else {
            responseData.setData(false);
        }
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    // Phương thức đăng ký người dùng
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest) {
        ResponseData responseData = new ResponseData();
        try {
            boolean isAdded = loginServiceImpl.addUser(signupRequest);
            responseData.setData(isAdded);
            responseData.setDescription("Sign-up successful!");
            return new ResponseEntity<>(responseData, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            responseData.setStatus(400); // Bad Request
            responseData.setDescription(e.getMessage());
            return new ResponseEntity<>(responseData, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            responseData.setStatus(500); // Internal Server Error
            responseData.setDescription("An unexpected error occurred. Please try again.");
            return new ResponseEntity<>(responseData, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Lấy thông tin người dùng hiện tại
    @GetMapping("/current-user")
    public ResponseEntity<UserDto> getCurrentUser(@RequestParam String username) {
        UserDto user = loginServiceImpl.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user); // Trả về thông tin người dùng nếu tìm thấy
        }
        return ResponseEntity.status(404).body(null); // Nếu không tìm thấy người dùng
    }


//	@GetMapping("/getalluser")
//	public ResponseEntity<?> getAllUser(){
//		ResponseData responseData = new ResponseData();
//		responseData.setData(loginServiceImpl.getAllUser());
//		return new ResponseEntity<>(responseData, HttpStatus.OK);
//	}
}
