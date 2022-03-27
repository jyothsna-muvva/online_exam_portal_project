package com.examportal.serviceImp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.examportal.constant.Constant;
//import com.examportal.dao.ProductDAO;
import com.examportal.repositories.UserDAO;
import com.examportal.service.UserService;
import com.examportal.dto.UserDTO;
import com.examportal.model.Login;
//import com.examportal.model.Product;
import com.examportal.model.User;
import com.examportal.exception.NoUserFoundException;

@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userRepo;
	//@Autowired
	//ProductDAO prodRepo;

	@Override
	public Boolean userRegister(User user) {

		Boolean flag = false;
		if (user == null) {
			return flag;
		}
		userRepo.save(user);
		flag = true;
		return flag;
	}

	@Override
	public User validateUser(Login login) {
		return userRepo.findByUsername(login.getUserName());
	}

	@Override
	public User getUserDetailsById(String userId) {

		return userRepo.findById(userId).orElseThrow(NoUserFoundException::new);

	}

	@Override
	public void deleteUser(String userName) {
		
		User userByUserName = userRepo.findByUsername(userName);
		userRepo.delete(userByUserName);

	}

	@Override
	public UserDTO updateUser(String userId, UserDTO userDTO) {
		UserDTO returnUserDTO = new UserDTO();
		User userEntityByUserId = userRepo.findByUserId(userId);

		if (userEntityByUserId == null) {
			throw new NoUserFoundException(Constant.RECORD_NOT_FOUND);
		}

		userEntityByUserId.setuFirstName(userDTO.getUserFirstName());
		userEntityByUserId.setuLastName(userDTO.getUserLastName());
		userEntityByUserId.setUserEmail(userDTO.getUserEmail());
		userEntityByUserId.setPassword(userDTO.getPassword());

		User updatedUserEntity = userRepo.save(userEntityByUserId);

		BeanUtils.copyProperties(updatedUserEntity, returnUserDTO);

		return returnUserDTO;
	}

	public User updateUser(User user) {

		String ue = user.getUserEmail();
		User ud = userRepo.findById(ue).get();

		ud.setUserId(user.getUserId());
		ud.setUserName(user.getUserName());
		ud.setPassword(user.getPassword());
		ud.setuFirstName(user.getuFirstName());
		ud.setuLastName(user.getuLastName());
		ud.setUserAddress(user.getUserAddress());
		ud.setPhone(user.getPhone());

		return userRepo.save(ud);
	}

	@Override
	public List<User> getAllUser() {
		return userRepo.findAll();
		
	}



}
