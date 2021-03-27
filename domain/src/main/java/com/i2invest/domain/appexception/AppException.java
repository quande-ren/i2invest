package com.i2invest.domain.appexception;

import lombok.Data;

public @Data class AppException extends Exception {
	public String getErrorCode() {
		return "100";
	}
	public String getErrorMessage() {
		return "General Error";
	}
	
}
