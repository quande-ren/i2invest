package com.i2invest.domain.response;

import com.i2invest.domain.dto.UserDto;

import lombok.Data;

public @Data class RetrieveUserResponse extends BaseResponse {
	public UserDto user;
	public RetrieveUserResponse() {
	}

	public RetrieveUserResponse(UserDto user) {
		this.user=user;
	}
	
}
