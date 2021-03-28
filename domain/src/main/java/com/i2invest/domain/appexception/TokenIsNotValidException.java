package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public  class TokenIsNotValidException extends AppException{
	public TokenIsNotValidException() {
	}
	
	public String getErrorCode() {
		return "106";
	}
	public String getErrorMessage() {
		return "Token Is Not Valid";
	}

}
