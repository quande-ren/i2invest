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
		response.clubsOwn=retrieveClubs(entityManager, clubsOwnedSql);
		
		String clubsInvestedSql = 
                     " SELECT   c.*   											\n"
		           + "   FROM   i2_club c										\n"
		           + "   join 	i2_userclubrole ucr on ucr.clubid= c.id 		\n"
		           + "   join 	i2_user usr on usr.email='"+request.email+	"'	\n" 
		           + "                     and usr.id=ucr.userid 				\n";
		response.clubsInvested=retrieveClubs(entityManager, clubsInvestedSql);

		String otherClubsSql = "select p.* "
				+ "	 from i2_Club p "
				+ " where p.clubName is not null  ";
		response.otherClubs=retrieveClubs(entityManager, otherClubsSql);
		
	}

	private List<ClubDto> retrieveClubs(EntityManager entityManager,  String clubsOwnedSql) {
		List<ClubEjb> clubEjbList= retrieveClubsByEmail(entityManager, 
				  clubsOwnedSql);
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
	
	public static List<ClubEjb> retrieveClubsByEmail(EntityManager entityManager, String ejbql) {
//		String ejbQL = "ejbql";
		Query query = entityManager.createNativeQuery(ejbql, ClubEjb.class);
		List<ClubEjb> list = query.getResultList();
		return list;
	}

}
