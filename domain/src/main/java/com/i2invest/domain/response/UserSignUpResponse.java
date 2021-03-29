package com.i2invest.domain.response;

import com.i2invest.domain.dto.UserDto;

import lombok.Data;

@Data
public  class UserSignUpResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public UserSignUpResponse() {
	}

	public UserSignUpResponse(UserDto user) {
		this.user=user;
	}
	
}
