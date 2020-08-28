package com.digitallbrarymanagementsystem.userDao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitallbrarymanagementsystem.dto.RegistrationDTO;
import com.digitallbrarymanagementsystem.model.RegistrationVo;
@Transactional
@Repository
public interface UserDoa extends CrudRepository<RegistrationVo,Long>{

	
	@Query(value = "SELECT * FROM registration WHERE userName = :userName", nativeQuery = true)
	List<RegistrationDTO> getUser(String userName);
	
	

}
