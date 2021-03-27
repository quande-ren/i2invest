package com.i2invest.ejb.processor;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.ForgotPasswordRequest;
import com.i2invest.domain.response.ForgotPasswordResponse;
import com.i2invest.ejb.AbstractRequestProcessor;

public  class ForgotPasswordRequestProcessor extends AbstractRequestProcessor<ForgotPasswordRequest, ForgotPasswordResponse>{

	public void process(EntityManager entityManager, ForgotPasswordRequest request, ForgotPasswordResponse response) throws AppException{
		response.newPassword="123";
	}
	
}
