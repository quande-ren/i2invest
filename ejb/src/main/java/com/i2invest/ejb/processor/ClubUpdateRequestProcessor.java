package com.i2invest.ejb.processor;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataNotFoundException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.appexception.NoPermissionToUpdateClubException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.ClubStartRequest;
import com.i2invest.domain.request.ClubUpdateRequest;
import com.i2invest.domain.response.ClubUpdateResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.RoleEjb;
import com.i2invest.ejb.entity.UserClubRoleEjb;
import com.i2invest.ejb.entity.UserEjb;

public class ClubUpdateRequestProcessor extends AbstractRequestProcessor<ClubUpdateRequest, ClubUpdateResponse> {
	public void process(EntityManager entityManager, ClubUpdateRequest request, ClubUpdateResponse response) throws AppException{
		UserEjb userEjb= UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		if(userEjb==null ) {
			throw new DataNotFoundException();
		}
		
		ClubEjb clubEjb = entityManager.find(ClubEjb.class, request.club.getId());
		if(clubEjb==null) {
			throw new DataNotFoundException("clubEjb id="+request.club.getId());
		}

		if( ! hasPermissionToUpdate(entityManager, clubEjb, userEjb) ) {
			throw new NoPermissionToUpdateClubException();
		}
		
		Date now=new Date();
		Timestamp nowTime = new Timestamp(now.getTime());

		clubEjb.setClubName(request.club.getClubName());
		clubEjb.setDescription(request.club.getDescription());
		clubEjb.setContactEmail(request.club.getContactEmail());
		clubEjb.setUpdateTime(nowTime);
		clubEjb.setUpdatedBy(userEjb.getId());
		
		entityManager.persist(clubEjb);
		
		response.user=response.user;
		response.club=new ClubDto(clubEjb);
	}

	private boolean hasPermissionToUpdate(EntityManager entityManager, ClubEjb clubEjb, UserEjb userEjb) {
		for(UserClubRoleEjb role: clubEjb.getUserRoles()) {
			if(role.getRole().getId().equals("CLUB_STARTER")) {
				return true;
			}
		}

		return false;
	}

	public void verifyData(ClubStartRequest request) throws MissingParameterException {
		if (request.club == null) {
			throw new MissingParameterException("club");
		}
		if (request.club.getId() == null) {
			throw new MissingParameterException("club.id");
		}
		if (request.club.getClubName() == null) {
			throw new MissingParameterException("club.clubName");
		}
		if (request.club.getContactEmail() == null) {
			throw new MissingParameterException("club.contactEmail");
		}
	}
	
	public static RoleEjb retrieveRoleById(EntityManager entityManager, String roleId) {
		RoleEjb role = entityManager.find(RoleEjb.class, roleId);
		if(role==null) {
			throw new RuntimeException("Role of "+roleId+" not found");
		}
		return role;
	}
	
}
