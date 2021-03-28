package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public  class EmailIsNotProvidedException extends AppException{
	public EmailIsNotProvidedException() {
	}
	
	public String getErrorCode() {
		return "108";
	}
	public String getErrorMessage() {
		return "Email Is Not Provided";
	}

}
