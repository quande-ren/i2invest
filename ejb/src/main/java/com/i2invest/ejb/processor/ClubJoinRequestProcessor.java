package com.i2invest.ejb.processor;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataAlreadyExistException;
import com.i2invest.domain.appexception.DataNotFoundException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.request.ClubJoinRequest;
import com.i2invest.domain.response.ClubJoinResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.RoleEjb;
import com.i2invest.ejb.entity.UserClubRoleEjb;
import com.i2invest.ejb.entity.UserEjb;

public class ClubJoinRequestProcessor extends AbstractRequestProcessor<ClubJoinRequest, ClubJoinResponse> {
	public void process(EntityManager entityManager, ClubJoinRequest request, ClubJoinResponse response) throws AppException{
		UserEjb userEjb= UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		ClubEjb clubEjb = entityManager.find(ClubEjb.class, request.clubId);
		if(clubEjb==null) {
			throw new DataNotFoundException("clubEjb id="+request.clubId);
		}
		List<UserClubRoleEjb> roles=clubEjb.getUserRoles();
		if(roles!=null && roles.size()>0) {
			for(UserClubRoleEjb userClubRoleEjb: roles) {
				if(userClubRoleEjb.getUser().getEmail().equals(userEjb.getEmail())) {
					throw new DataAlreadyExistException("User is already a memebre of the club");
				}
			}
		}
		
		RoleEjb roleEjb=ClubStartRequestProcessor.retrieveRoleById(entityManager, "CLUB_APPLY");
		
		UserClubRoleEjb userClubRoleEjb=new UserClubRoleEjb();
		userClubRoleEjb.setRole(roleEjb);
		userClubRoleEjb.setUser(userEjb);
		userClubRoleEjb.setClub(clubEjb);
		
		Timestamp nowTime = new Timestamp(new Date().getTime());
		userClubRoleEjb.setCreateTime(nowTime);
		userClubRoleEjb.setUpdateTime(nowTime);
		
		entityManager.persist(userClubRoleEjb);
		
		response.success=true;
	}

	public void verifyData(ClubJoinRequest request) throws MissingParameterException {
		if (request.clubId == null) {
			throw new MissingParameterException("clubId");
		}
	}
	
}
