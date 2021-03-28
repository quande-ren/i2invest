package com.i2invest.ejb.processor;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.i2invest.domain.UserDto;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataNotFoundException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.request.RetrieveUserRequest;
import com.i2invest.domain.response.RetrieveUserResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.UserEjb;

public  class RetrieveUserRequestProcessor 
		extends AbstractRequestProcessor<RetrieveUserRequest, RetrieveUserResponse> 
		implements TokenRequiredRequestProcessor{

	public void process(EntityManager entityManager, RetrieveUserRequest request, RetrieveUserResponse response) throws AppException{
		List<UserEjb> list = retrieveUserByEmail(entityManager, request.searchEmail);
		if(list!=null && list.size()>0) {
			UserEjb ejb=list.get(0);
			response.user=new UserDto(ejb);
		}else {
			throw new DataNotFoundException(request.searchEmail);
		}
	}
	
	public boolean requireToken() {
		return true;
	}

	
	public static List<UserEjb> retrieveUserByEmail(EntityManager entityManager, String email) {
		String ejbQL = "From UserEjb b where b.email = ?1";
		Query query = entityManager.createQuery(ejbQL);
		query.setParameter(1, email);
		List<UserEjb> list = query.getResultList();
		return list;
	}

	public void verifyData(RetrieveUserRequest request) throws MissingParameterException {
		if(request.email==null) {
			throw new MissingParameterException("email", "RetrieveUserRequest");
		}
	}
}
