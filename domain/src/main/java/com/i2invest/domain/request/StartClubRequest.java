package com.i2invest.domain.request;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.response.StartClubResponse;

import lombok.Data;

@Data
public  class StartClubRequest extends BaseRequest<StartClubResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ClubDto club;
	
	public StartClubRequest() {
		
	}

	public  StartClubResponse getDummayResponse() {
		return new StartClubResponse();
	}

}
