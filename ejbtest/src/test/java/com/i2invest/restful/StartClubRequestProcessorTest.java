package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.StartClubRequest;
import com.i2invest.domain.response.StartClubResponse;

public class StartClubRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=SignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		StartClubRequest startClubRequest=new StartClubRequest();
		startClubRequest.email=TestUtil.email;
		startClubRequest.token=token;
		startClubRequest.club=new ClubDto();
		startClubRequest.club.setClubName("Albert Shi Invest");
		startClubRequest.club.setContactEmail(TestUtil.email);
		
		
		StartClubResponse startClubResponse=(StartClubResponse) facadeService.processRequest(startClubRequest);
		
		assertNotNull(startClubResponse.club);
		
	}

}
