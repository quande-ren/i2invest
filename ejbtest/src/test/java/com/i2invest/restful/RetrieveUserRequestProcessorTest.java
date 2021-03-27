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
		String email="quande.ren@gmail.com";
		String password="Yanmei123";
		

		SignInResponse signInResponse= (SignInResponse)facadeService.processRequest(new SignInRequest(email, password));
		
		assertNotNull(signInResponse.user);
		assertNotNull(signInResponse.user.getFirstName());
		assertNotNull(signInResponse.user.getLastName());
		assertNotNull(signInResponse.token);
		
		RetrieveUserRequest retrieveUserRequest=new RetrieveUserRequest(signInResponse.token, email, email);
		RetrieveUserResponse retrieveUserResponse=(RetrieveUserResponse) facadeService.processRequest(retrieveUserRequest);
		
		assertNotNull(retrieveUserResponse);
		assertNotNull(retrieveUserResponse.user);
		
		retrieveUserRequest=new RetrieveUserRequest("abc", email, email);
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
		String email="quande.ren@gmail.com2";
		String password="Yanmei123";

		try {
			SignInResponse signInResponse= (SignInResponse)facadeService.processRequest(new SignInRequest(email, password));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

	@Test
	public void testPasswordNotCorrect() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		String email="quande.ren@gmail.com";
		String password="Yanmei1234444";
		
		try {
			SignInResponse signInResponse= (SignInResponse)facadeService.processRequest(new SignInRequest(email, password));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

}
