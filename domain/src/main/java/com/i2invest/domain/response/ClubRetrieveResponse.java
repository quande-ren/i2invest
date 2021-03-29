package com.i2invest.domain.response;

import java.util.List;

import com.i2invest.domain.dto.ClubDto;

import lombok.Data;

@Data
public  class ClubRetrieveResponse extends BaseResponse {
	private static final long serialVersionUID = -3922026779808905917L;

	public ClubDto club;
	public List<ClubDto> clubs;
	
	public ClubRetrieveResponse() {
	}

	public ClubRetrieveResponse(ClubDto club) {
		this.club=club;
	}

	public ClubRetrieveResponse(List<ClubDto> clubs) {
		this.clubs=clubs;
	}

}
