package com.i2invest.domain.request;

import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.response.SignUpResponse;

import lombok.Data;

@Data
public  class SignUpRequest extends BaseRequest<SignUpResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public UserDto user;
	
	public SignUpRequest() {
		
	}

	public SignUpRequest(UserDto user) {
		this.user=user;
	}
	
	public  SignUpResponse getDummayResponse() {
		return new SignUpResponse();
	}

}
