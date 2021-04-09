package com.i2invest.domain.request;

import com.i2invest.domain.dto.ClubDto;
import com.i2invest.domain.response.ClubResponse;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public  class ClubRequest extends BaseRequest<ClubResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ClubDto club;
	
	public static final String RequestType_RetrieveClubApplications="RetrieveClubApplications";

	public ClubRequest() {
		
	}

	public  ClubResponse getDummayResponse() {
		return new ClubResponse();
	}

}
