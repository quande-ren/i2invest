package com.i2invest.domain.request;

import com.i2invest.domain.response.SignInResponse;

import lombok.Data;

public @Data class SignInRequest extends BaseRequest<SignInResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public String password;
	
	public SignInRequest() {
		
	}

	public SignInRequest(String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	public  SignInResponse getDummayResponse() {
		return new SignInResponse();
	}

}
