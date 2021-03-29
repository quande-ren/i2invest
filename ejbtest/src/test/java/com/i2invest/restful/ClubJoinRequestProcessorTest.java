package com.i2invest.restful;

import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.ClubJoinRequest;
import com.i2invest.domain.response.ClubJoinResponse;

public class ClubJoinRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		ClubJoinRequest request=new ClubJoinRequest();
		request.email=TestUtil.email;
		request.token=token;
		request.clubId=12L;
		
		
		ClubJoinResponse response=(ClubJoinResponse) facadeService.processRequest(request);
		
		assertTrue(response.success);
		
	}

}
