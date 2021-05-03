package com.i2invest.domain.response;

import java.util.List;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.dto.UserClubRoleDto;
import com.i2invest.domain.dto.UserDto;

import lombok.Data;

@Data
public  class ClubResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public UserDto user;
	public ClubDto club;
	public List<ClubDto> clubs;
	public List<UserClubRoleDto> clubUsers;
	public ClubResponse() {
	}

	public ClubResponse(UserDto user, ClubDto club) {
		this.user=user;
		this.club=club;
	}

	public ClubResponse(List<ClubDto> clubs) {
		this.clubs=clubs;
	}

	public ClubResponse(List<ClubDto> clubs, List<UserClubRoleDto> clubUsers) {
		this.clubs=clubs;
		this.clubUsers=clubUsers;
	}

}
