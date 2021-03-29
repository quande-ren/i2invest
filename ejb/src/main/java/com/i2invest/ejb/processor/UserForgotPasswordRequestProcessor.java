package com.i2invest.ejb.processor;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.UserForgotPasswordRequest;
import com.i2invest.domain.response.UserForgotPasswordResponse;
import com.i2invest.ejb.AbstractRequestProcessor;

public  class UserForgotPasswordRequestProcessor extends AbstractRequestProcessor<UserForgotPasswordRequest, UserForgotPasswordResponse>{

	public void process(EntityManager entityManager, UserForgotPasswordRequest request, UserForgotPasswordResponse response) throws AppException{
		response.newPassword="123";
	}
	
}
