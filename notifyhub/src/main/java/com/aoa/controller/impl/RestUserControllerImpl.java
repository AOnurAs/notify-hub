package com.aoa.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aoa.controller.IRestUserController;
import com.aoa.controller.RestBaseController;
import com.aoa.dto.DtoUser;
import com.aoa.dto.DtoUserIU;
import com.aoa.dto.RootEntity;
import com.aoa.service.IUserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class RestUserControllerImpl extends RestBaseController implements IRestUserController {
	
	@Autowired
	private IUserService userService;

	@Override
	@PostMapping(path = "/save-user")
	public RootEntity<DtoUser> saveUser(@RequestBody @Valid DtoUserIU dtoUserIU) {
		return ok(userService.saveUser(dtoUserIU));
	}

	@Override
	@PostMapping(path = "/update-user/{id}")
	public RootEntity<DtoUser> updateUser(@PathVariable(name = "id") Long id, @RequestBody @Valid DtoUserIU dtoUserIU) {
		return ok(userService.updateUser(id, dtoUserIU));
	}

	@Override
	@DeleteMapping(path = "/delete/{id}")
	public RootEntity<Boolean> deleteUser(@PathVariable(name = "id") Long id) {
		return ok(userService.deleteUser(id));
	}


}
