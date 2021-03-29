package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.InvalidCredential;
import com.i2invest.domain.appexception.TokenIsNotValidException;
import com.i2invest.domain.request.UserRetrieveRequest;
import com.i2invest.domain.request.UserSignInRequest;
import com.i2invest.domain.response.UserRetrieveResponse;
import com.i2invest.domain.response.UserSignInResponse;

public class UserRetrieveRequestProcessorTest {
	

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		UserRetrieveRequest retrieveUserRequest=new UserRetrieveRequest(token, TestUtil.email, TestUtil.email);
		UserRetrieveResponse retrieveUserResponse=(UserRetrieveResponse) facadeService.processRequest(retrieveUserRequest);
		
		assertNotNull(retrieveUserResponse);
		assertNotNull(retrieveUserResponse.user);
		
		retrieveUserRequest=new UserRetrieveRequest("abc", TestUtil.email, TestUtil.email);
		try {
			retrieveUserResponse=(UserRetrieveResponse) facadeService.processRequest(retrieveUserRequest);
			fail("should not go to here");
		}catch (TokenIsNotValidException e) {
			//should go here.
		}
		
	}

	@Test
	public void testEmailNotFount() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();

		try {
			UserSignInResponse signInResponse= (UserSignInResponse)facadeService.processRequest(new UserSignInRequest(TestUtil.email+"NotFount", TestUtil.password));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

	@Test
	public void testPasswordNotCorrect() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		try {
			UserSignInResponse signInResponse= (UserSignInResponse)facadeService.processRequest(new UserSignInRequest(TestUtil.email, TestUtil.password+"WrongPassword"));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

}
