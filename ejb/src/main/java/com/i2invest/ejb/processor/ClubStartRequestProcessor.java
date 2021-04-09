package com.i2invest.ejb.processor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataNotFoundException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.dto.RoleDto;
import com.i2invest.domain.request.ClubStartRequest;
import com.i2invest.domain.response.ClubStartResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.RoleEjb;
import com.i2invest.ejb.entity.UserClubRoleEjb;
import com.i2invest.ejb.entity.UserEjb;

public class ClubStartRequestProcessor extends AbstractRequestProcessor<ClubStartRequest, ClubStartResponse> {
	public void process(EntityManager entityManager, ClubStartRequest request, ClubStartResponse response, UserEjb currentUserEjb) throws AppException{
		UserEjb userEjb= UserRetrieveRequestProcessor.retrieveUserByEmail(entityManager, request.email);
		if(userEjb==null ) {
			throw new DataNotFoundException();
		}
		
		ClubEjb clubEjb=new ClubEjb(request.club);
		Date now=new Date();
		Timestamp nowTime = new Timestamp(now.getTime());
		clubEjb.setCreateTime(nowTime);
		clubEjb.setUpdateTime(nowTime);
		clubEjb.setId(null);
		entityManager.persist(clubEjb);
		
		RoleEjb roleEjb=retrieveRoleById(entityManager, RoleDto.ROLE_CLUB_STARTER);
		
		UserClubRoleEjb userClubRole = new UserClubRoleEjb();
		userClubRole.setUser(userEjb);
		userClubRole.setRole(roleEjb);
		userClubRole.setClub(clubEjb);
		userClubRole.setCreateTime(nowTime);
		userClubRole.setUpdateTime(nowTime);
		
		List<UserClubRoleEjb> userRoles = clubEjb.getUserRoles();
		if(userRoles==null) {
			userRoles=new ArrayList<UserClubRoleEjb>();
			clubEjb.setUserRoles(userRoles);
		}
		userRoles.add(userClubRole);
		
		entityManager.persist(userClubRole);
		entityManager.persist(clubEjb);
		
		ClubDto newClub=new ClubDto();
		newClub.copyPropertiesFrom(clubEjb);

		response.user=response.user;
		response.club=newClub;
	}

	public void verifyData(ClubStartRequest request) throws MissingParameterException {
		if (request.club == null) {
			throw new MissingParameterException("club");
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
