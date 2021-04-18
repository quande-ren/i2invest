package com.i2invest.domain.request;

import com.i2invest.domain.dto.PropertyDto;
import com.i2invest.domain.response.PropertyResponse;

import lombok.Data;

@Data
public  class PropertyRequest extends BaseRequest<PropertyResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public PropertyDto property;
	
	public PropertyRequest() {
	}
	public PropertyRequest(String requestType) {
		this.requestType=requestType;
	}

	public PropertyRequest(String requestType, PropertyDto property ) {
		this.requestType=requestType;
		this.property=property;
	}

	public  PropertyResponse getDummayResponse() {
		return new PropertyResponse();
	}
	
	@Override
	public String toString() {
		return "PropertyRequest[ email="+email+" property="+property+"]";
	}

}
