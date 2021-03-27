package com.i2invest.domain.response;

import com.i2invest.domain.UserDto;

import lombok.Data;

public @Data class SignInResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public String token;
	public SignInResponse() {
	}

	public SignInResponse(UserDto user) {
		this.user=user;
	}

	public SignInResponse(String token, UserDto user) {
		this.user=user;
		this.token=token;
	}

}
