package com.i2invest.ejb.processor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataAlreadyExistException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.SignInRequest;
import com.i2invest.domain.request.SignUpRequest;
import com.i2invest.domain.response.SignInResponse;
import com.i2invest.domain.response.SignUpResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;

public class SignUpRequestProcessor extends AbstractRequestProcessor<SignUpRequest, SignUpResponse> {
	public void process(EntityManager entityManager, SignUpRequest request, SignUpResponse response) throws AppException{
		UserEjb userEjb= RetrieveUserRequestProcessor.retrieveUserByEmail(entityManager, request.user.getEmail());
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

	public void verifyData(SignUpRequest request) throws MissingParameterException {
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
