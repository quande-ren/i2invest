package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.request.ClubRequest;
import com.i2invest.domain.response.ClubResponse;
import com.i2invest.domain.response.ClubUpdateResponse;

public class ClubRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.emailAlbert, TestUtil.password);
		
		
		ClubRequest request=new ClubRequest();
		request.email=TestUtil.emailAlbert;
		request.token=token;
		request.requestType=ClubRequest.RequestType_RetrieveJoinApplocations;

		ClubResponse response=(ClubResponse) facadeService.processRequest(request);
		
		assertNotNull(response.clubs);
		
	}

}
