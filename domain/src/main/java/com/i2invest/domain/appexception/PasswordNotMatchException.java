package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public  class PasswordNotMatchException extends AppException{
	public String getErrorCode() {
		return "106";
	}
	public String getErrorMessage() {
		return "Password Not Match";
	}

}
