package com.i2invest.domain.request;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.response.ClubUpdateResponse;

import lombok.Data;

@Data
public  class ClubUpdateRequest extends BaseRequest<ClubUpdateResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ClubDto club;
	
	public ClubUpdateRequest() {
		
	}

	public  ClubUpdateResponse getDummayResponse() {
		return new ClubUpdateResponse();
	}

}
