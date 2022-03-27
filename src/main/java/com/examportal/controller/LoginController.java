//package com.examportal.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.examportal.constant.Constant;
//import com.examportal.exception.NoUserFoundException;
//import com.examportal.model.Login;
//import com.examportal.model.User;
//import com.examportal.service.UserService;
//
//@RestController
//	public class LoginController {
//
//		@Autowired
//		UserService userService;
//
//		@PostMapping(value = "/user/loginProcess")
//		public String login(@RequestBody Login login) throws NoUserFoundException {
//
//			User user = userService.validateUser(login);
//
//			boolean isValidUser = false;
//
//			if (null != user) {
//				if ((user.getUserName().equals(login.getUserName()) && user.getPassword().equals(login.getPassword()))) {
//					isValidUser = true;
//				} else {
//
//					throw new NoUserFoundException();
//				}
//
//			}
//
//			return isValidUser ? Constant.SUCCESSFULLY_LOGGED_IN : Constant.LOGGED_IN_FAILED;
//		}
//
//		@GetMapping("/login")
//		public String login() {
//			return "login";
//		}
//
//	}
//
//
//
