package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.ClubStartRequest;
import com.i2invest.domain.response.ClubStartResponse;

public class ClubStartRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		ClubStartRequest startClubRequest=new ClubStartRequest();
		startClubRequest.email=TestUtil.email;
		startClubRequest.token=token;
		startClubRequest.club=new ClubDto();
		startClubRequest.club.setClubName("Albert Shi Invest");
		startClubRequest.club.setContactEmail(TestUtil.email);
		
		
		ClubStartResponse startClubResponse=(ClubStartResponse) facadeService.processRequest(startClubRequest);
		
		assertNotNull(startClubResponse.club);
		
	}

}
