package com.i2invest.domain.appexception;

import lombok.Data;

public @Data class MissingParameterException extends AppException{
	public MissingParameterException(String parameterName, String source) {
		this.setParameterName(parameterName);
		this.setSource(source);
	}
	public MissingParameterException() {
	}
	
	public String getParameterName() {
		return parameterName;
	}
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}

	private String parameterName;
	private String source;
	
	public String getErrorCode() {
		return "104";
	}
	public String getErrorMessage() {
		return "Missing Parameter: "+parameterName;
	}

}
