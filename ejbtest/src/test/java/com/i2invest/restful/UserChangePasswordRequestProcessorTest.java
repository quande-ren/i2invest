package com.i2invest.restful;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.UserProfileUpdateRequest;
import com.i2invest.domain.response.UserProfileUpdateResponse;

public class UserChangePasswordRequestProcessorTest {

	@Test
	public void testSuccess() throws NamingException, AppException {
		FacadeService facadeService = TestUtil.getFacadeService();
		
		String token=UserSignInRequestProcessorTest.doSignIn(facadeService, TestUtil.email, TestUtil.oldPassword);


		UserProfileUpdateRequest request = new UserProfileUpdateRequest(TestUtil.email, TestUtil.oldPassword);
		request.token=token;

		request.requestType=UserProfileUpdateRequest.RequestType_ChangePassword;
		request.oldPassword=TestUtil.oldPassword;
		request.newPassword=TestUtil.newPassword;
		
		UserProfileUpdateResponse response= (UserProfileUpdateResponse)facadeService.processRequest(request);

		request.requestType=UserProfileUpdateRequest.RequestType_ChangePassword;
		request.oldPassword=TestUtil.newPassword;
		request.newPassword=TestUtil.oldPassword;
		
		response= (UserProfileUpdateResponse)facadeService.processRequest(request);

	}

}
