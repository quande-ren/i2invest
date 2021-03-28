package com.i2invest.domain.response;

import com.i2invest.domain.dto.UserDto;

import lombok.Data;

public @Data class SignUpResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public SignUpResponse() {
	}

	public SignUpResponse(UserDto user) {
		this.user=user;
	}
	
}
