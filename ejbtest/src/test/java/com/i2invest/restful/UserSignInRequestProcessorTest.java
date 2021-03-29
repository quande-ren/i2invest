package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.InvalidCredential;
import com.i2invest.domain.request.UserSignInRequest;
import com.i2invest.domain.response.UserSignInResponse;

public class UserSignInRequestProcessorTest {

	public static String doSignIn(FacadeService facadeService, String email, String password) throws AppException {

		UserSignInResponse signInResponse= (UserSignInResponse)facadeService.processRequest(new UserSignInRequest(email, password));

		assertNotNull(signInResponse.user);
		assertNotNull(signInResponse.user.getFirstName());
		assertNotNull(signInResponse.user.getLastName());
		assertNotNull(signInResponse.token);
		
		return signInResponse.token;

	}

	
	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		String email="quande.ren@gmail.com";
		String password="Yanmei123";
		

		UserSignInResponse signInResponse= (UserSignInResponse)facadeService.processRequest(new UserSignInRequest(email, password));
		
		assertNotNull(signInResponse.user);
		assertNotNull(signInResponse.user.getFirstName());
		assertNotNull(signInResponse.user.getLastName());
		assertNotNull(signInResponse.token);
	}

	@Test
	public void testEmailNotFount() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		String email="quande.ren@gmail.com2";
		String password="Yanmei123";

		try {
			UserSignInResponse signInResponse= (UserSignInResponse)facadeService.processRequest(new UserSignInRequest(email, password));
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
			UserSignInResponse signInResponse= (UserSignInResponse)facadeService.processRequest(new UserSignInRequest(email, password));
			fail("should not go to here");
		}catch (InvalidCredential e) {
			
		}
	}

}
