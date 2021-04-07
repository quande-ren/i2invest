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
		String clubsOwnedSql = "select p.* "
			+ "	 from i2_Club p "
			+ " where p.clubName is not null "
			+ "   and p.ownerId in ( "
			+ "               select id"
			+ "               from i2_user "
			+ "               where email='"+request.email+"'"
			+ "               )  ";
		response.clubsOwn=retrieveClubDtos(entityManager, clubsOwnedSql);
		
		String clubsInvestedSql = 
                     " SELECT   c.*   											\n"
		           + "   FROM   i2_club c										\n"
		           + "   join 	i2_userclubrole ucr on ucr.clubid= c.id 		\n"
		           + "   join 	i2_user usr on usr.email='"+request.email+	"'	\n" 
		           + "                     and usr.id=ucr.userid 				\n";
		response.clubsInvested=retrieveClubDtos(entityManager, clubsInvestedSql);

		String otherClubsSql = "select p.* "
				+ "	 from i2_Club p "
				+ " where p.clubName is not null and p.publicVisible=1 ";
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
	
	public static List<ClubEjb> retrieveClubEjbs(EntityManager entityManager, String ejbql) {
		Query query = entityManager.createNativeQuery(ejbql, ClubEjb.class);
		List<ClubEjb> list = query.getResultList();
		return list;
	}

}
