package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.UserForgotPasswordRequest;
import com.i2invest.domain.response.UserForgotPasswordResponse;

public class UserForgotPasswordRequestProcessorTest {

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		UserForgotPasswordRequest request = new UserForgotPasswordRequest(TestUtil.email);

		UserForgotPasswordResponse response= (UserForgotPasswordResponse)facadeService.processRequest(request);

		assertNotNull(response.newPassword);

	}

}
