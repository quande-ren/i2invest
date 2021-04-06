package com.i2invest.domain.request;

import com.i2invest.domain.dto.ConfigDto;
import com.i2invest.domain.response.ConfigResponse;

import lombok.Data;

@Data
public  class ConfigRequest extends BaseRequest<ConfigResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ConfigDto config;
	
	public ConfigRequest() {
	}
	public ConfigRequest(String requestType) {
		this.requestType=requestType;
	}

	public ConfigRequest(String requestType, ConfigDto config ) {
		this.requestType=requestType;
		this.config=config;
	}

	public  ConfigResponse getDummayResponse() {
		return new ConfigResponse();
	}

}
