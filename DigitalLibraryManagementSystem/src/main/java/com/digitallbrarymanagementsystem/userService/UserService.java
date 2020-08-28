package com.digitallbrarymanagementsystem.userService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.digitallbrarymanagementsystem.dto.RegistrationDTO;
import com.digitallbrarymanagementsystem.model.RegistrationVo;
import com.digitallbrarymanagementsystem.userDao.LoginDAO;
import com.digitallbrarymanagementsystem.userDao.UserDoa;

@Transactional
@Service
public class UserService {

	@Autowired
	public UserDoa userDao;
	@Autowired(required = true)
	public LoginDAO loginDAO;

	@Transactional
	public String userRegistration(RegistrationDTO registration) {

		List<RegistrationDTO> list = userDao.getUser(registration.getUserName());

		if (list.size() > 0) {
			return "already present";

		} else {
			RegistrationVo registrationVo = new RegistrationVo();
			registrationVo.setAdmin(registration.isAdmin());
			registrationVo.setPassword(registration.getPassword());
			registrationVo.setUserName(registration.getUserName());
			userDao.save(registrationVo);
			return "registration successfull";

		}

	}

}
