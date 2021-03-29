package com.i2invest.domain.request;

import com.i2invest.domain.response.ClubJoinResponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper=true)
public  class ClubJoinRequest extends BaseRequest<ClubJoinResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public Long clubId;
	
	public ClubJoinRequest() {
		
	}

	public  ClubJoinResponse getDummayResponse() {
		return new ClubJoinResponse();
	}
	
}
