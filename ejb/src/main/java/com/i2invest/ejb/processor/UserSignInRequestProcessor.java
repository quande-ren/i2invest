package com.i2invest.ejb.processor;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.InvalidCredential;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.UserSignInRequest;
import com.i2invest.domain.request.UserSignUpRequest;
import com.i2invest.domain.response.UserSignInResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;
import com.i2invest.util.JwtUtil;

public class UserSignInRequestProcessor extends AbstractRequestProcessor<UserSignInRequest, UserSignInResponse> {

	public void process(EntityManager entityManager, UserSignInRequest request, UserSignInResponse response, UserEjb currentUserEjb) throws AppException{
		UserDto inUser = new UserDto();
		inUser.setEmail(request.email);
		inUser.setPassword(request.password);
		
		UserEjb userEjb= UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		if(userEjb==null ) {
			throw new InvalidCredential();
		}
		if(inUser.getPasswordHash().equals(userEjb.getPasswordHash())) {
			UserDto newUser=new UserDto();
			newUser.copyPropertiesFrom(userEjb);
			response.token=JwtUtil.generateToken(newUser.getEmail());
			response.user=newUser;
		}else {
			throw new InvalidCredential();
		}
		
	}

	public void verifyData(UserSignUpRequest request) throws MissingParameterException {
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
