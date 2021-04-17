package com.i2invest.domain.request;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.response.ClubCreateResponse;

import lombok.Data;

@Data
public  class ClubCreateRequest extends BaseRequest<ClubCreateResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ClubDto club;
	
	public ClubCreateRequest() {
		
	}

	public  ClubCreateResponse getDummayResponse() {
		return new ClubCreateResponse();
	}

}
