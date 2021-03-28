package com.i2invest.ejb;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.BaseRequest;
import com.i2invest.domain.response.BaseResponse;

public abstract class AbstractRequestProcessor<RQS extends BaseRequest, RSP extends BaseResponse> {
	public abstract void process(EntityManager entityManager, RQS request, RSP response) throws AppException;
	
	public void verifyData(RQS request) throws AppException{
	};
	
}
