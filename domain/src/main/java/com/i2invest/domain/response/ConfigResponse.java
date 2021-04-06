package com.i2invest.domain.response;

import com.i2invest.domain.dto.ConfigDto;

import lombok.Data;

@Data
public  class ConfigResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public ConfigDto config;
	public ConfigDto[] configs;
	public ConfigResponse() {
	}

	public ConfigResponse(ConfigDto config) {
		this.config=config;
	}

	public ConfigResponse(ConfigDto[] configs) {
		this.configs=configs;
	}

	
}
