package com.i2invest.ejb.processor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.UserClubRoleDto;
import com.i2invest.domain.request.ClubRequest;
import com.i2invest.domain.response.ClubResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.UserClubRoleEjb;
import com.i2invest.ejb.entity.UserEjb;

public  class ClubRequestProcessor 
		extends AbstractRequestProcessor<ClubRequest, ClubResponse> 
		implements TokenRequiredRequestProcessor{

	public void process(EntityManager entityManager, ClubRequest request, ClubResponse response, UserEjb currentUserEjb) throws AppException{
		if(ClubRequest.RequestType_RetrieveClubUsers.equals(request.requestType)) {
			Long clubId = request.club.getId();
			ClubEjb club=entityManager.find(ClubEjb.class, clubId);
			List<UserClubRoleEjb> users=club.getUserRoles();
			List<UserClubRoleDto> clubUsers=convertUserClubRoles(entityManager, club, users);
			response.clubUsers=clubUsers;
		}else {
			throw new RuntimeException("Not recognised requestType["+request.requestType+"]");
		}
	}

	private List<UserClubRoleDto> convertUserClubRoles(EntityManager entityManager, ClubEjb clubEjb, List<UserClubRoleEjb> userRoleEjbs) {
		List<UserClubRoleDto> result = new ArrayList<UserClubRoleDto>();
		for(  UserClubRoleEjb ejb: userRoleEjbs) {
			result.add(convertEjbToDto(clubEjb, ejb));
		}
		return result;
	}

	private UserClubRoleDto convertEjbToDto(ClubEjb clubEjb, UserClubRoleEjb ejb) {
		UserClubRoleDto result = new UserClubRoleDto(ejb);
		result.setClubId(clubEjb.getId());
		result.setClubName(clubEjb.getName());
		result.setRoleId(ejb.getRole().getId());
		result.setRoleName(ejb.getRole().getRoleType());
		result.setFirstName(ejb.getUser().getFirstName());
		result.setLastName(ejb.getUser().getLastName());
		result.setUserId(ejb.getUser().getId());
		return result;
	}
	
	

}
