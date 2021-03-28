package com.i2invest.domain.response;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public   class BaseResponse extends BaseDto{
	public boolean success;
	public String errorCode;
	public String errorMessage;
	
	public BaseResponse() {
		success=true;
	}
	
	public BaseResponse(boolean success, String errorCode, String errorMessage) {
		this.success=success;
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}

	public BaseResponse(String errorCode, String errorMessage) {
		this.success=false;
		this.errorCode=errorCode;
		this.errorMessage=errorMessage;
	}

}
