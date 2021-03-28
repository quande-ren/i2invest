package com.i2invest.domain.appexception;

import lombok.Data;

public @Data class InvalidCredential extends AppException{
	public String getErrorCode() {
		return "103";
	}
	public String getErrorMessage() {
		return "Invalid Credential";
	}

}
