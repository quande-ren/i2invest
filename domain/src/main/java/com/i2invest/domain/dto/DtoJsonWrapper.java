package com.i2invest.domain.dto;

import com.i2invest.domain.BaseDto;

public  class DtoJsonWrapper extends BaseDto{
	public String type;
	public String jsonString;
	
	public DtoJsonWrapper() {}
	
	public DtoJsonWrapper(String type, String jsonString) {
		this.type=type;
		this.jsonString=jsonString;
	}
	
	public BaseDto getPayloadDto() {
		return DtoFactory.getDto(type, jsonString);
	}
	
}
