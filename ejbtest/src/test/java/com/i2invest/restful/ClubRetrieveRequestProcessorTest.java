package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.ClubRetrieveRequest;
import com.i2invest.domain.response.ClubRetrieveResponse;

public class ClubRetrieveRequestProcessorTest {
	

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		ClubRetrieveRequest retrieveUserRequest=new ClubRetrieveRequest(token, TestUtil.email, ClubRetrieveRequest.RetrieveType_BY_USER, null);
		retrieveUserRequest.retrieveType="select p.* from i2_Club p where p.clubName is not null";
		ClubRetrieveResponse retrieveUserResponse=(ClubRetrieveResponse) facadeService.processRequest(retrieveUserRequest);
		
		assertNotNull(retrieveUserResponse);
		assertNotNull(retrieveUserResponse.clubsOwn);
		assertTrue(retrieveUserResponse.clubsOwn.size()>0);
		
		for(ClubDto club: retrieveUserResponse.clubsOwn) {
			System.out.println(club);
		}
		
	}

}
