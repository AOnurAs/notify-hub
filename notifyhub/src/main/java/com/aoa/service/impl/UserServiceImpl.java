package com.aoa.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aoa.dto.DtoMail;
import com.aoa.dto.DtoUser;
import com.aoa.dto.DtoUserIU;
import com.aoa.entities.Mail;
import com.aoa.entities.User;
import com.aoa.exception.BaseExcepiton;
import com.aoa.exception.ErrorMessage;
import com.aoa.exception.MessageType;
import com.aoa.repository.MailRepository;
import com.aoa.repository.UserRepository;
import com.aoa.service.IUserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MailRepository mailRepository;
	
	public User createUser(DtoUserIU dtoUserIU){
		User user = new User();
		user.setCreateTime(new Date());
		Mail mail = new Mail();
		mail.setCreateTime(new Date());

		BeanUtils.copyProperties(dtoUserIU.getMail(), mail);
		BeanUtils.copyProperties(dtoUserIU, user);
		
		user.setMail(mail);
		
		return user;
	}
	
	public DtoUser createDtoUser(User user) {
		DtoUser dtoUser = new DtoUser();
		DtoMail dtoMail = new DtoMail();
		
		BeanUtils.copyProperties(user, dtoUser);
		BeanUtils.copyProperties(user.getMail(), dtoMail);
		
		dtoUser.setMail(dtoMail);
		
		return dtoUser;
		
	}

	@Override
	public DtoUser saveUser(DtoUserIU dtoUserIU) {
		User user = createUser(dtoUserIU);
		mailRepository.save(user.getMail());
		userRepository.save(user);
		
		return createDtoUser(user);
	}
	
	@Transactional
	@Override
	public DtoUser updateUser(Long id, DtoUserIU IUUser) {
	    User dbUser = userRepository.findById(id)
	            .orElseThrow(() -> new BaseExcepiton(
	                    new ErrorMessage(MessageType.NO_RECORD_EXIST, "updateUser id: " + id)));

	    dbUser.setName(IUUser.getName());
	    dbUser.setPassword(IUUser.getPassword());
	    dbUser.setUsername(IUUser.getUsername());

	    if (IUUser.getMail() != null) {
	        if (dbUser.getMail() == null) {
	            dbUser.setMail(new Mail());
	        }
	        BeanUtils.copyProperties(IUUser.getMail(), dbUser.getMail());
	    }

	    User updatedUser = userRepository.save(dbUser);

	    DtoUser dtoUser = new DtoUser();
	    BeanUtils.copyProperties(updatedUser, dtoUser);

	    return dtoUser;
	}

	
	@Transactional
	@Override
	public boolean deleteUser(Long id) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new BaseExcepiton(
						new ErrorMessage(MessageType.NO_RECORD_EXIST, "(deleteUser funciton) Record of user with id " + id + " couldnt be found in the database")));
		
	    userRepository.delete(user);
	    return true;
	}


}
