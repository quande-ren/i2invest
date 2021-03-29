package com.i2invest.domain.request;

import com.i2invest.domain.response.UserForgotPasswordResponse;

import lombok.Data;

@Data
public  class UserForgotPasswordRequest extends BaseRequest<UserForgotPasswordResponse>{
	public String username;
	
	public UserForgotPasswordRequest() {
		
	}

	public UserForgotPasswordRequest(String username) {
		this.username=username;
	}
	
	public  UserForgotPasswordResponse getDummayResponse() {
		return new UserForgotPasswordResponse();
	}

}
