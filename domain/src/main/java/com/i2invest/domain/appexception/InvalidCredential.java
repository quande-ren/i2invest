package com.i2invest.domain.appexception;

public class InvalidCredential extends AppException{
	public String getErrorCode() {
		return "103";
	}
	public String getErrorMessage() {
		return "Invalid Credential";
	}

}
