package com.i2invest.ejb.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.RoleDto;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.ClubRequest;
import com.i2invest.domain.response.ClubResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.UserEjb;

public  class ClubRequestProcessor 
		extends AbstractRequestProcessor<ClubRequest, ClubResponse> 
		implements TokenRequiredRequestProcessor{

	public void process(EntityManager entityManager, ClubRequest request, ClubResponse response) throws AppException{
		if(ClubRequest.RequestType_RetrieveClubApplocations.equals(request.requestType)) {
			UserEjb userEjb=UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.email);
			response.clubs=ClubRetrieveRequestProcessor.convertClubsToDto(userEjb.getClubsOwn());
			response.clubUsers=new ArrayList<UserDto>();
			List<UserDto> users= new ArrayList<UserDto>();
			for(ClubEjb clubEjb: userEjb.getClubsOwn()) {
				clubEjb.getUserRoles()
					.stream()
					.filter(r -> r.getRole().getId().equals(RoleDto.ROLE_CLUB_APPLY))
					.forEach(ucr-> {
										UserDto u=new UserDto(ucr.getUser());
										u.setClubName(clubEjb.getClubName());
										users.add(u); 
									}
							);
			}
			response.clubUsers=users;
		}
	}
	
	

}
