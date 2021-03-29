package com.i2invest.domain.response;

import com.i2invest.domain.dto.UserDto;

import lombok.Data;

@Data
public  class UserSignInResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public String token;
	public UserSignInResponse() {
	}

	public UserSignInResponse(UserDto user) {
		this.user=user;
	}

	public UserSignInResponse(String token, UserDto user) {
		this.user=user;
		this.token=token;
	}

}
