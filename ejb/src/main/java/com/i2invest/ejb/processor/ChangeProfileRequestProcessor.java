package com.i2invest.ejb.processor;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.InvalidCredential;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.appexception.PasswordNotMatchException;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.ChangeProfileRequest;
import com.i2invest.domain.request.SignUpRequest;
import com.i2invest.domain.response.ChangeProfileResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;

public class ChangeProfileRequestProcessor extends AbstractRequestProcessor<ChangeProfileRequest, ChangeProfileResponse> implements TokenRequiredRequestProcessor{

	public void process(EntityManager entityManager, ChangeProfileRequest request, ChangeProfileResponse response) throws AppException{
		UserDto inUser = new UserDto();
		inUser.setEmail(request.email);

		UserEjb userEjb= RetrieveUserRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		if(userEjb==null ) {
			throw new InvalidCredential();
		}
		
		if(request.changePasswordOnly) {
			changePassword(entityManager, userEjb, request.oldPassword, request.newPassword);
		}
		
	}
	
	public boolean requireToken() {
		return true;
	}


	private void changePassword(EntityManager entityManager, UserEjb userEjb, String oldPassword,
			String newPassword) throws PasswordNotMatchException {
		UserDto user = new UserDto();
		user.setEmail(userEjb.getEmail());
		user.setPassword(oldPassword);
		if(user.getPasswordHash().equals(userEjb.getPasswordHash())) {
			user.setPassword(newPassword);
			userEjb.setPasswordHash(user.getPasswordHash());
			entityManager.persist(userEjb);
		}else {
			throw new PasswordNotMatchException();
		}
	}

	public void verifyData(SignUpRequest request) throws MissingParameterException {
		if (request.user == null) {
			throw new MissingParameterException("user", "SignInRequest");
		}
		if (request.user.getEmail() == null) {
			throw new MissingParameterException("user.email", "SignInRequest");
		}
		if (request.user.getPassword() == null) {
			throw new MissingParameterException("user.password", "SignInRequest");
		}
	}
}
