package com.i2invest.restful;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.ChangeProfileRequest;
import com.i2invest.domain.response.ChangeProfileResponse;

public class ChangePasswordRequestProcessorTest {

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		String token=SignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.oldPassword);


		ChangeProfileRequest request = new ChangeProfileRequest(TestUtil.email, TestUtil.oldPassword);
		request.token=token;

		request.changePasswordOnly=true;
		request.oldPassword=TestUtil.oldPassword;
		request.newPassword=TestUtil.newPassword;
		
		ChangeProfileResponse response= (ChangeProfileResponse)facadeService.processRequest(request);

		request.changePasswordOnly=true;
		request.oldPassword=TestUtil.newPassword;
		request.newPassword=TestUtil.oldPassword;
		
		response= (ChangeProfileResponse)facadeService.processRequest(request);

	}

}
