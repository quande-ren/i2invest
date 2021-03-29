package com.i2invest.domain.request;

import com.i2invest.domain.response.UserRetrieveResponse;

import lombok.Data;

@Data
public  class UserRetrieveRequest extends BaseRequest<UserRetrieveResponse>{
	public String searchEmail;
	
	public UserRetrieveRequest() {
		
	}

	public UserRetrieveRequest(String token, String email, String searchEmail) {
		this.email=email;
		this.token=token;
		this.searchEmail=searchEmail;
	}
	
	public  UserRetrieveResponse getDummayResponse() {
		return new UserRetrieveResponse();
	}


}
