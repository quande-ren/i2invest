package com.i2invest.ejb.processor;

import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.UserDto;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.InvalidCredential;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.request.RetrieveUserRequest;
import com.i2invest.domain.request.SignInRequest;
import com.i2invest.domain.request.SignUpRequest;
import com.i2invest.domain.response.RetrieveUserResponse;
import com.i2invest.domain.response.SignInResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;
import com.i2invest.util.JwtUtil;

public class SignInRequestProcessor extends AbstractRequestProcessor<SignInRequest, SignInResponse> {

	public void process(EntityManager entityManager, SignInRequest request, SignInResponse response) throws AppException{
		UserDto inUser = new UserDto();
		inUser.setEmail(request.email);
		inUser.setPassword(request.password);
		
		List<UserEjb> list = RetrieveUserRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		if (list == null || list.size() < 1) {
			throw new InvalidCredential();
		}
		UserEjb userEjb = list.get(0);
		if(inUser.getPasswordHash().equals(userEjb.getPasswordHash())) {
			UserDto newUser=new UserDto();
			newUser.copyPropertiesFrom(userEjb);
			response.token=JwtUtil.generateToken(newUser.getEmail());
			response.user=newUser;
		}else {
			throw new InvalidCredential();
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
