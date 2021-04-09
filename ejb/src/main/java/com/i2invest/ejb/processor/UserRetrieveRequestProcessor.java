package com.i2invest.ejb.processor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataNotFoundException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.UserRetrieveRequest;
import com.i2invest.domain.response.UserRetrieveResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.UserEjb;

public  class UserRetrieveRequestProcessor 
		extends AbstractRequestProcessor<UserRetrieveRequest, UserRetrieveResponse> 
		implements TokenRequiredRequestProcessor{

	public void process(EntityManager entityManager, UserRetrieveRequest request, UserRetrieveResponse response, UserEjb currentUserEjb) throws AppException{
		UserEjb ejb= retrieveUserByEmail(entityManager, request.searchEmail);
		if(ejb!=null ) {
			response.user=new UserDto(ejb);
		}else {
			throw new DataNotFoundException(request.searchEmail);
		}
	}
	
	public boolean requireToken() {
		return true;
	}

	public static List<UserDto> convertUsersToDto(List<UserEjb> clubEjbList) {
		List<UserDto> result = new ArrayList<UserDto>();
		if(clubEjbList!=null ) {
			for(UserEjb ejb : clubEjbList) {
				UserDto dto=new UserDto();
				dto.copyPropertiesFrom(ejb);
				result.add(dto);
			}
		}
		return result;
	}

	
	public static UserEjb retrieveUserByEmail(EntityManager entityManager, String email) {
		String ejbQL = "From UserEjb b where b.email = ?1";
		Query query = entityManager.createQuery(ejbQL);
		query.setParameter(1, email);
		List<UserEjb> list = query.getResultList();
		if(list!=null && list.size()>0) {
			return list.get(0);
		}
		return null;
	}

	public void verifyData(UserRetrieveRequest request) throws MissingParameterException {
		if(request.email==null) {
			throw new MissingParameterException("email", "RetrieveUserRequest");
		}
	}
}
