package com.aoa.controller;

import com.aoa.dto.DtoUser;
import com.aoa.dto.DtoUserIU;
import com.aoa.dto.RootEntity;

import jakarta.validation.Valid;

public interface IRestUserController {
	
	public RootEntity<DtoUser> saveUser(DtoUserIU dtoUserIU);
	
	public RootEntity<DtoUser> updateUser(Long id, @Valid DtoUserIU dtoUserIU);
	
	public RootEntity<Boolean> deleteUser(Long id);


}
