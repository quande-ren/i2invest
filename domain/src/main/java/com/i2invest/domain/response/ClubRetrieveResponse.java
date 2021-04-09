package com.i2invest.domain.response;

import java.util.List;

import com.i2invest.domain.dto.ClubDto;

import lombok.Data;

@Data
public  class ClubRetrieveResponse extends BaseResponse {
	private static final long serialVersionUID = -3922026779808905917L;

	public ClubDto club;
	public List<ClubDto> clubsOwn;
	public List<ClubDto> clubsInterested;
	public List<ClubDto> otherClubs;
	
	public ClubRetrieveResponse() {
	}

	public ClubRetrieveResponse(ClubDto club) {
		this.club=club;
	}

	public ClubRetrieveResponse(List<ClubDto> clubsOwn, List<ClubDto> clubsInterested, List<ClubDto> otherClubs) {
		this.clubsOwn=clubsOwn;
		this.clubsInterested=clubsInterested;
		this.otherClubs=otherClubs;
	}

}
