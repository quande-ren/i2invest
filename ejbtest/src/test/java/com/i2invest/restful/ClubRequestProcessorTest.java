package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.dto.UserClubRoleDto;
import com.i2invest.domain.request.ClubRequest;
import com.i2invest.domain.response.ClubResponse;

public class ClubRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.emailAlbert, TestUtil.password);
		
		
		ClubRequest request=new ClubRequest();
		request.email=TestUtil.emailAlbert;
		request.token=token;
		request.requestType=ClubRequest.RequestType_RetrieveClubUsers;
		request.club=new ClubDto();
		request.club.setId(71L);

		ClubResponse response=(ClubResponse) facadeService.processRequest(request);
		
		assertNotNull(response.clubUsers);
		assertNotNull(response.clubUsers);
		for(UserClubRoleDto user: response.clubUsers) {
			assertNotNull(user.getClub().getName());
			assertNotNull(user.getClub().getId());
			
			assertNotNull(user.getUser().getId());
			assertNotNull(user.getUser().getFirstName());
			assertNotNull(user.getUser().getLastName());
			
			assertNotNull(user.getRole().getId());
			assertNotNull(user.getRole().getRoleName());
			assertNotNull(user.getId());
			
		}
		
	}

}
