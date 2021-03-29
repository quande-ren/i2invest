package com.i2invest.domain.response;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.dto.UserDto;

import lombok.Data;

@Data
public  class ClubStartResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public ClubDto club;
	public ClubStartResponse() {
	}

	public ClubStartResponse(UserDto user, ClubDto club) {
		this.user=user;
		this.club=club;
	}
	
}
