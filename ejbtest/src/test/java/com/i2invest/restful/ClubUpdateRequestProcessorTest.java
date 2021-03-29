package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.ClubUpdateRequest;
import com.i2invest.domain.response.ClubUpdateResponse;

public class ClubUpdateRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		ClubUpdateRequest startClubRequest=new ClubUpdateRequest();
		startClubRequest.email=TestUtil.email;
		startClubRequest.token=token;
		startClubRequest.club=new ClubDto();
		startClubRequest.club.setId(12L);
		startClubRequest.club.setDescription("Albert Shi Invest, welcome to join.");
		startClubRequest.club.setClubName("Albert Shi Invest...");
		startClubRequest.club.setContactEmail(TestUtil.email);
		
		
		ClubUpdateResponse startClubResponse=(ClubUpdateResponse) facadeService.processRequest(startClubRequest);
		
		assertNotNull(startClubResponse.club);
		
	}

}
