package com.i2invest.restful;


import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.UserDto;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.ForgotPasswordRequest;
import com.i2invest.domain.request.SignUpRequest;

public class FacadeEjbTest {

	@Test
	public void testIt() throws NamingException, AppException {
		
	    FacadeService facadeService = TestUtil.getFacadeService();
		
	    facadeService.sayHelloFromServiceBean();
	    facadeService.processRequest(new SignUpRequest(new UserDto("aaa","bbb")));

	    facadeService.processRequest(new ForgotPasswordRequest("aaa"));

	}



}
