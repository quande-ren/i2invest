package com.i2invest.domain.response;

import com.i2invest.domain.dto.UserDto;

import lombok.Data;

@Data
public  class UserProfileChangeResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public UserProfileChangeResponse() {
	}

	public UserProfileChangeResponse(UserDto user) {
		this.user=user;
	}

}
