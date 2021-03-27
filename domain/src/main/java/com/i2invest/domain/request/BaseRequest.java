package com.i2invest.domain.request;

import com.i2invest.domain.BaseDto;
import com.i2invest.domain.response.BaseResponse;

public abstract class BaseRequest<R extends BaseResponse> extends BaseDto{
	private static final long serialVersionUID = -7369800986300844786L;
	public String email;
	public String token;
	
	public abstract R getDummayResponse();
	
	
	public BaseRequest() {
	}
}
