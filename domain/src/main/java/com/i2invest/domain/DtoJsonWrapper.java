package com.i2invest.domain;

import lombok.Data;

@Data
public  class DtoJsonWrapper extends BaseDto{
	private static final long serialVersionUID = 5147340025896592681L;
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
	
	@Override
	public String toString() {
		return "DtoJsonWrapper( type="+type+" jsonString="+jsonString+")";
	}
	
}
