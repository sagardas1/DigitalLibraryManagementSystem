package com.digitallbrarymanagementsystem.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.digitallbrarymanagementsystem.baseResponce.BaseResponce;
import com.digitallbrarymanagementsystem.dto.RegistrationDTO;
import com.digitallbrarymanagementsystem.model.RegistrationVo;
import com.digitallbrarymanagementsystem.responceConstants.ResponceConstants;
import com.digitallbrarymanagementsystem.userService.UserService;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	public UserService userService;

	
	@Transactional
	@PostMapping(value = "/userregistration", headers = "Accept=application/json")
	public String userRegistration(@RequestBody RegistrationDTO registration) {

		return userService.userRegistration(registration);

	}

}
