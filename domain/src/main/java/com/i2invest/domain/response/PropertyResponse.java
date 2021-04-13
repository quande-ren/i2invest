package com.i2invest.domain.response;

import com.i2invest.domain.dto.PropertyDto;

import lombok.Data;

@Data
public  class PropertyResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public PropertyDto property;
	public PropertyDto[] properties;
	public PropertyResponse() {
	}

	public PropertyResponse(PropertyDto property) {
		this.property=property;
	}

	public PropertyResponse(PropertyDto[] properties) {
		this.properties=properties;
	}

	
}
