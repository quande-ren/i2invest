package com.i2invest.domain.appexception;

import lombok.Data;

public @Data class DataAlreadyExistException extends AppException{
	public DataAlreadyExistException(String duplicate) {
		this.duplicate=duplicate;
	}
	public DataAlreadyExistException() {
	}
	
	public String duplicate;
	
	public String getErrorCode() {
		return "101";
	}
	public String getErrorMessage() {
		return "Data Already Exist : "+duplicate;
	}

}
