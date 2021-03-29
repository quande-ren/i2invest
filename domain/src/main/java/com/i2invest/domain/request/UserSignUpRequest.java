package com.i2invest.domain.request;

import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.response.UserSignUpResponse;

import lombok.Data;

@Data
public  class UserSignUpRequest extends BaseRequest<UserSignUpResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public UserDto user;
	
	public UserSignUpRequest() {
		
	}

	public UserSignUpRequest(UserDto user) {
		this.user=user;
	}
	
	public  UserSignUpResponse getDummayResponse() {
		return new UserSignUpResponse();
	}

}
