package com.i2invest.restful;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.UserProfileChangeRequest;
import com.i2invest.domain.response.UserProfileChangeResponse;

public class UserChangePasswordRequestProcessorTest {

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.oldPassword);


		UserProfileChangeRequest request = new UserProfileChangeRequest(TestUtil.email, TestUtil.oldPassword);
		request.token=token;

		request.requestType=UserProfileChangeRequest.RequestType_ChangePassword;
		request.oldPassword=TestUtil.oldPassword;
		request.newPassword=TestUtil.newPassword;
		
		UserProfileChangeResponse response= (UserProfileChangeResponse)facadeService.processRequest(request);

		request.requestType=UserProfileChangeRequest.RequestType_ChangePassword;
		request.oldPassword=TestUtil.newPassword;
		request.newPassword=TestUtil.oldPassword;
		
		response= (UserProfileChangeResponse)facadeService.processRequest(request);

	}

}
