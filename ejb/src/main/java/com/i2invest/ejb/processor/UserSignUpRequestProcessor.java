package com.i2invest.ejb.processor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataAlreadyExistException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.UserSignInRequest;
import com.i2invest.domain.request.UserSignUpRequest;
import com.i2invest.domain.response.UserSignInResponse;
import com.i2invest.domain.response.UserSignUpResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;

public class UserSignUpRequestProcessor extends AbstractRequestProcessor<UserSignUpRequest, UserSignUpResponse> {
	public void process(EntityManager entityManager, UserSignUpRequest request, UserSignUpResponse response) throws AppException{
		UserEjb userEjb= UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.user.getEmail());
		if(userEjb!=null ) {
			throw new DataAlreadyExistException(request.user.getEmail());
		}

		UserEjb ejb=new UserEjb();
		ejb.copyPropertiesFrom(request.user);
		ejb.setPasswordHash(request.user.getPasswordHash());
		Date now=new Date();
		ejb.setCreateTime(new Timestamp(now.getTime()));
		ejb.setUpdateTime(new Timestamp(now.getTime()));
		ejb.setId(null);
		entityManager.persist(ejb);
		
		UserDto newUser=new UserDto();
		newUser.copyPropertiesFrom(ejb);

		response.user=newUser;
	}

	public void verifyData(UserSignUpRequest request) throws MissingParameterException {
		if (request.user == null) {
			throw new MissingParameterException("user", "SignUpRequest");
		}
		if (request.user.getEmail() == null) {
			throw new MissingParameterException("user.email", "SignUpRequest");
		}
		if (request.user.getFirstName() == null) {
			throw new MissingParameterException("user.firstName", "SignUpRequest");
		}
		if (request.user.getLastName() == null) {
			throw new MissingParameterException("user.lastName", "SignUpRequest");
		}
	}
}
