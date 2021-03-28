package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.InvalidCredential;
import com.i2invest.domain.appexception.TokenIsNotValidException;
import com.i2invest.domain.request.RetrieveUserRequest;
import com.i2invest.domain.request.SignInRequest;
import com.i2invest.domain.response.RetrieveUserResponse;
import com.i2invest.domain.response.SignInResponse;

public class RetrieveUserRequestProcessorTest {
	

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		
		String token=SignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.password);
		
		
		RetrieveUserRequest retrieveUserRequest=new RetrieveUserRequest(token, TestUtil.email, TestUtil.email);
		RetrieveUserResponse retrieveUserResponse=(RetrieveUserResponse) facadeService.processRequest(retrieveUserRequest);
		
		assertNotNull(retrieveUserResponse);
		assertNotNull(retrieveUserResponse.user);
		
		retrieveUserRequest=new RetrieveUserRequest("abc", TestUtil.email, TestUtil.email);
		try {
			retrieveUserResponse=(RetrieveUserResponse) facadeService.processRequest(retrieveUserRequest);
			fail("should not go to here");
		}catch (TokenIsNotValidException e) {
			//should go here.
		}
		
	}

	@Test
	public void testEmailNotFount() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();

		try {
			SignInResponse signInResponse= (SignInResponse)facadeService.processRequest(new SignInRequest(TestUtil.email+"NotFount", TestUtil.password));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

	@Test
	public void testPasswordNotCorrect() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		try {
			SignInResponse signInResponse= (SignInResponse)facadeService.processRequest(new SignInRequest(TestUtil.email, TestUtil.password+"WrongPassword"));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

}
