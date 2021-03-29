package com.i2invest.restful;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.DataAlreadyExistException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.request.UserRetrieveRequest;
import com.i2invest.domain.request.UserSignUpRequest;
import com.i2invest.domain.response.UserRetrieveResponse;

public class UserSignUpRequestProcessorTest {

	@Test
	public void testIt() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		String email=TestUtil.email;

		try {
			facadeService.processRequest(new UserSignUpRequest(new UserDto("firstName", null/* email is null*/)));
			fail("Should not go to here");
		}catch (MissingParameterException e) {
			assertEquals(e.getParameterName(), "user.email");
		}

		try {
			facadeService.processRequest(new UserSignUpRequest(new UserDto(null, email/* firstName is null*/)));
			fail("Should not go to here");
		}catch (MissingParameterException e) {
			assertEquals(e.getParameterName(), "user.firstName");
		}

		UserDto user = new UserDto("Quande", "Ren", email);
		user.setPhoneNum("123");
		user.setPassword(TestUtil.password);
		facadeService.processRequest(new UserSignUpRequest(user));

		try {
			facadeService.processRequest(new UserSignUpRequest(user));
			fail("Should not go to here");
		}catch (DataAlreadyExistException e) {
			assertEquals(e.duplicate, email);
		}
		
		UserRetrieveResponse retrieveUserResponse=(UserRetrieveResponse) facadeService.processRequest(new UserRetrieveRequest(email, email, email));
		
		assertNotNull(retrieveUserResponse);
		assertNotNull(retrieveUserResponse.user);
		assertNotNull(retrieveUserResponse.user.getEmail());
		assertEquals(retrieveUserResponse.user.getEmail(), email);
		assertNotNull(retrieveUserResponse.user.getCreateTime());
		assertNotNull(retrieveUserResponse.user.getUpdateTime());
		assertNotNull(retrieveUserResponse.user.getPhoneNum());
		assertNotNull(retrieveUserResponse.user.getFirstName());
		assertNotNull(retrieveUserResponse.user.getLastName());
		

	}

}
