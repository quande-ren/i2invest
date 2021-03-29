package com.i2invest.domain.request;

import com.i2invest.domain.response.UserSignInResponse;

import lombok.Data;

@Data
public  class UserSignInRequest extends BaseRequest<UserSignInResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public String password;
	
	public UserSignInRequest() {
		
	}

	public UserSignInRequest(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public  UserSignInResponse getDummayResponse() {
		return new UserSignInResponse();
	}

}
