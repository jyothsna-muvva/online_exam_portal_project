package com.examportal.service;

import java.util.List;


import com.examportal.dto.UserDTO;
import com.examportal.model.Login;
import com.examportal.model.User;

public interface UserService {

	public Boolean userRegister(User user);

	public User validateUser(Login login);

	public User getUserDetailsById(String userId);



	public List<User> getAllUser();

	public void deleteUser(String userName);

	public UserDTO updateUser(String userId, UserDTO userDTO);

	public User updateUser(User user);

}
