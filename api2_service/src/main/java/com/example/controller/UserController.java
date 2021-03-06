package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.schema.UserResponse;
import com.example.schema.UserRqt;
import com.example.service.UserService;


@RestController
@RequestMapping("/api2/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
		return new ResponseEntity<UserResponse>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<UserResponse> addUser(@RequestBody UserRqt userRqt) {
		return new ResponseEntity<UserResponse>(userService.addUser(this.UserRequestToUser(userRqt)), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserResponse> updateUser(@RequestBody UserRqt userRqt) {
		return new ResponseEntity<UserResponse>(userService.updateUser(this.UserRequestToUserupdate(userRqt)), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{userId}")
	public ResponseEntity<UserResponse> deleteUser(@PathVariable("userId")  Long userId) {
		return new ResponseEntity<UserResponse>(userService.deleteUser(userId), HttpStatus.OK);
	}

	 public User UserRequestToUser(UserRqt userRqt) {
			User user = new User();
			user.setName(userRqt.getRqtname());
			user.setDob(userRqt.getRqtdob());
			user.setEmail(userRqt.getRqtemail());
			user.setMobile(userRqt.getRqtmobile());
			return user;
		}
	 public User UserRequestToUserupdate(UserRqt userRqt) {
			User user = new User();
			user.setUserId(userRqt.getRqtuserId());
			user.setName(userRqt.getRqtname());
			user.setDob(userRqt.getRqtdob());
			user.setEmail(userRqt.getRqtemail());
			user.setMobile(userRqt.getRqtmobile());
			return user;
		}
	
}
