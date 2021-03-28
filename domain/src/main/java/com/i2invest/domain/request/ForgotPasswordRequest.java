package com.i2invest.domain.request;

import com.i2invest.domain.response.ForgotPasswordResponse;

import lombok.Data;

@Data
public  class ForgotPasswordRequest extends BaseRequest<ForgotPasswordResponse>{
	public String username;
	
	public ForgotPasswordRequest() {
		
	}

	public ForgotPasswordRequest(String username) {
		this.username=username;
	}
	
	public  ForgotPasswordResponse getDummayResponse() {
		return new ForgotPasswordResponse();
	}

}
