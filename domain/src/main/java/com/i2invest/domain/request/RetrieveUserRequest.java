package com.i2invest.domain.request;

import com.i2invest.domain.response.RetrieveUserResponse;

import lombok.Data;

@Data
public  class RetrieveUserRequest extends BaseRequest<RetrieveUserResponse>{
	public String searchEmail;
	
	public RetrieveUserRequest() {
		
	}

	public RetrieveUserRequest(String token, String email, String searchEmail) {
		this.email=email;
		this.token=token;
		this.searchEmail=searchEmail;
	}
	
	public  RetrieveUserResponse getDummayResponse() {
		return new RetrieveUserResponse();
	}


}
