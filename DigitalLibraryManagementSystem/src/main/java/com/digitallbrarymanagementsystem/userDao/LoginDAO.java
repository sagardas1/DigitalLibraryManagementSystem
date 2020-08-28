package com.digitallbrarymanagementsystem.userDao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digitallbrarymanagementsystem.model.LoginVo;


@Repository
@Transactional
public interface LoginDAO  extends CrudRepository<LoginVo,Long>{
	
	


}
