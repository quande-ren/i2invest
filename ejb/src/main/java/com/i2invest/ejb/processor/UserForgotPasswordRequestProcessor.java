package com.i2invest.ejb.processor;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataNotFoundException;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.UserForgotPasswordRequest;
import com.i2invest.domain.response.UserForgotPasswordResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;

public  class UserForgotPasswordRequestProcessor extends AbstractRequestProcessor<UserForgotPasswordRequest, UserForgotPasswordResponse>{

	public void process(EntityManager entityManager, UserForgotPasswordRequest request, UserForgotPasswordResponse response) throws AppException{
		UserEjb userEjb= UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		if(userEjb==null ) {
			throw new DataNotFoundException(request.email);
		}
		
		UserDto userDto=new UserDto(userEjb);
		userDto.setPassword("123456");

		userEjb.setPasswordHash(userDto.getPasswordHash());
		userEjb.setUpdateTime(new Timestamp(new Date().getTime()));
		userEjb.setUpdatedBy(userEjb.getId());
		
		entityManager.persist(userEjb);

		response.newPassword=userDto.getPassword();
		
		
	}
	
}
