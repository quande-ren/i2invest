package com.i2invest.ejb.processor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.ClubRetrieveRequest;
import com.i2invest.domain.response.ClubRetrieveResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;

public  class ClubRetrieveRequestProcessor 
		extends AbstractRequestProcessor<ClubRetrieveRequest, ClubRetrieveResponse> 
		implements TokenRequiredRequestProcessor{

	public void process(EntityManager entityManager, ClubRetrieveRequest request, ClubRetrieveResponse response) throws AppException{
		List<ClubEjb> clubEjbList= retrieveClubsByEmail(entityManager, request.retrieveType);
		List<ClubDto> result = new ArrayList<ClubDto>();
		if(clubEjbList!=null ) {
			for(ClubEjb ejb : clubEjbList) {
				ClubDto dto=new ClubDto();
				dto.copyPropertiesFrom(ejb);
				result.add(dto);
			}
			response.clubs=result;
		}
	}
	
	public static List<ClubEjb> retrieveClubsByEmail(EntityManager entityManager, String ejbql) {
//		String ejbQL = "ejbql";
		Query query = entityManager.createNativeQuery(ejbql, ClubEjb.class);
		List<ClubEjb> list = query.getResultList();
		return list;
	}

}
