package com.aoa.service;

import com.aoa.dto.DtoUserIU;
import com.aoa.dto.DtoUser;

public interface IUserService {

	public DtoUser saveUser(DtoUserIU user);
	
	public DtoUser updateUser(Long id, DtoUserIU user);
	
	public boolean deleteUser(Long id);
	

}
