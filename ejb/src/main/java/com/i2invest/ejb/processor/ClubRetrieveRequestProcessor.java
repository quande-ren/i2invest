package com.i2invest.ejb.processor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.dto.RoleDto;
import com.i2invest.domain.request.ClubRetrieveRequest;
import com.i2invest.domain.response.ClubRetrieveResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.TokenRequiredRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.UserEjb;

public  class ClubRetrieveRequestProcessor 
		extends AbstractRequestProcessor<ClubRetrieveRequest, ClubRetrieveResponse> 
		implements TokenRequiredRequestProcessor{
	private static final Logger logger=Logger.getLogger(ClubRetrieveRequestProcessor.class.getName());


	public void process(EntityManager entityManager, ClubRetrieveRequest request, ClubRetrieveResponse response, UserEjb currentUserEjb) throws AppException{
		String clubsOwnedSql = 
			  " select c.* 																	\n"
			+ "	  from i2_Club c 															\n"
			+ "   join i2_userclubrole ucr on ucr.userid = "+currentUserEjb.getId()+"		\n"			
			+ "                           and ucr.clubId = c.id 							\n"
			+ "                           and ucr.roleId = '"+ RoleDto.ROLE_CLUB_STARTER+"'	\n"
			+ "  where c.clubName is not null 												\n";
		response.clubsOwn=retrieveClubDtos(entityManager, clubsOwnedSql);
		
		String clubsInterestedSql = 
                     " SELECT   c.*   															\n"
		           + "   FROM   i2_club c													 	\n"
				   + "   join   i2_userclubrole ucr on ucr.userid ="+currentUserEjb.getId()+" 	\n"
				   + "                             and ucr.clubId = c.id 						\n"
				   + "                             and ucr.roleId != '"+ RoleDto.ROLE_CLUB_STARTER+"'";
		response.clubsInterested=retrieveClubDtos(entityManager, clubsInterestedSql);

		String otherClubsSql = 
				  "select c.* 															\n"
				+ "	 from i2_Club c 													\n"
				+ " where c.clubName is not null 										\n"
				+ "   and c.publicVisible=1 											\n"
				+ "   and c.id not in (     select clubid 								\n"
				+ "                           from i2_userclubrole 						\n"
				+ "                          where userid="+currentUserEjb.getId()+"	\n"
			    + "                       ) ";
		response.otherClubs=retrieveClubDtos(entityManager, otherClubsSql);
		
	}

	public static List<ClubDto> retrieveClubDtos(EntityManager entityManager,  String clubsOwnedSql) {
		List<ClubEjb> clubEjbList= retrieveClubEjbs(entityManager, 
				  clubsOwnedSql);
		return convertClubsToDto(clubEjbList);
	}

	public static List<ClubDto> convertClubsToDto(List<ClubEjb> clubEjbList) {
		List<ClubDto> result = new ArrayList<ClubDto>();
		if(clubEjbList!=null ) {
			for(ClubEjb ejb : clubEjbList) {
				ClubDto dto=new ClubDto();
				dto.copyPropertiesFrom(ejb);
				result.add(dto);
			}
		}
		return result;
	}
	
	public static List<ClubEjb> retrieveClubEjbs(EntityManager entityManager, String sql) {
		logger.info("get result by sql=\n"+sql);
		Query query = entityManager.createNativeQuery(sql, ClubEjb.class);
		List<ClubEjb> list = query.getResultList();
		return list;
	}

}
