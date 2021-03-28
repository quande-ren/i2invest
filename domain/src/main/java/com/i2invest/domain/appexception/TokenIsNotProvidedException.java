package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public  class TokenIsNotProvidedException extends AppException{
	public TokenIsNotProvidedException() {
	}
	
	public String getErrorCode() {
		return "105";
	}
	public String getErrorMessage() {
		return "Token Is Not Provided";
	}

}
