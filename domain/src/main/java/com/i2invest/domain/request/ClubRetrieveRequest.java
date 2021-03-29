package com.i2invest.domain.request;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.response.ClubRetrieveResponse;

import lombok.Data;

@Data
public  class ClubRetrieveRequest extends BaseRequest<ClubRetrieveResponse>{
	public ClubDto club;
	public String retrieveType;
	public static final String RetrieveType_BY_USER="BY_USER";
	
	public ClubRetrieveRequest() {
		
	}

	public ClubRetrieveRequest(String token, String email, String retrieveType, ClubDto club) {
		this.email=email;
		this.token=token;
		this.club=club;
		this.retrieveType=retrieveType;
	}
	
	public  ClubRetrieveResponse getDummayResponse() {
		return new ClubRetrieveResponse();
	}


}
