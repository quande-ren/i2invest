package com.i2invest.domain.request;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.response.ClubStartResponse;

import lombok.Data;

@Data
public  class ClubStartRequest extends BaseRequest<ClubStartResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ClubDto club;
	
	public ClubStartRequest() {
		
	}

	public  ClubStartResponse getDummayResponse() {
		return new ClubStartResponse();
	}

}
