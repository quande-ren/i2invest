package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public class NameAlreadyExistException extends AppException{
	public NameAlreadyExistException(String name) {
		this.name=name;
	}
	public NameAlreadyExistException() {
	}
	
	private String name;
	
	public String getErrorCode() {
		return "109";
	}
	public String getErrorMessage() {
		return "Name Already Exist : "+name;
	}

}
