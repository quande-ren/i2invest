package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public class DataAlreadyExistException extends AppException{
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
