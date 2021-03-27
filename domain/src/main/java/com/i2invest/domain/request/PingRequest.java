package com.i2invest.domain.request;

import com.i2invest.domain.response.PingResponse;

import lombok.Data;

public @Data class PingRequest extends BaseRequest<PingResponse>{
	public  PingResponse getDummayResponse() {
		return new PingResponse();
	}

	
}
