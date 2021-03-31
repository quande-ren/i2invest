package com.i2invest.domain.request;

import com.i2invest.domain.response.UserForgotPasswordResponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public  class UserForgotPasswordRequest extends BaseRequest<UserForgotPasswordResponse>{
	public UserForgotPasswordRequest() {
		
	}

	public UserForgotPasswordRequest(String email) {
		this.email=email;
	}
	
	public  UserForgotPasswordResponse getDummayResponse() {
		return new UserForgotPasswordResponse();
	}
	
}
