package com.i2invest.domain.response;

import com.i2invest.domain.UserDto;

import lombok.Data;

public @Data class ChangeProfileResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public ChangeProfileResponse() {
	}

	public ChangeProfileResponse(UserDto user) {
		this.user=user;
	}

}
