package com.i2invest.domain.appexception;

import lombok.Data;

public @Data class TokenIsNotValidException extends AppException{
	public TokenIsNotValidException() {
	}
	
	public String getErrorCode() {
		return "106";
	}
	public String getErrorMessage() {
		return "Token Is Not Valid";
	}

}
