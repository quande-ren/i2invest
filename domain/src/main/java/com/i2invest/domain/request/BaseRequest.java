package com.i2invest.domain.request;

import com.i2invest.domain.BaseDto;
import com.i2invest.domain.response.BaseResponse;

import lombok.Data;

@Data
public abstract class BaseRequest<R extends BaseResponse> extends BaseDto{
	private static final long serialVersionUID = -7369800986300844786L;
	public String email;
	public String token;
	public String requestType;

	
	public static final String RequestType_Create="Create";
	public static final String RequestType_Update="Update";
	public static final String RequestType_Delete="Delete";
	public static final String RequestType_Retrieve="Retrieve";
	
	public abstract R getDummayResponse();
	
	
	public BaseRequest() {
	}
}
