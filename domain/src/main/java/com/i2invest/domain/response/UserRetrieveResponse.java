package com.i2invest.domain.response;

import com.i2invest.domain.dto.UserDto;

import lombok.Data;

@Data
public  class UserRetrieveResponse extends BaseResponse {
	public UserDto user;
	public UserRetrieveResponse() {
	}

	public UserRetrieveResponse(UserDto user) {
		this.user=user;
	}
	
}
