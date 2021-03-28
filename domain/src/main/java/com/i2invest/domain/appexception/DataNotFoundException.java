package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public class DataNotFoundException extends AppException{
	public DataNotFoundException(String searchData) {
		this.searchData=searchData;
	}
	public DataNotFoundException() {
	}
	
	public String getSearchData() {
		return searchData;
	}
	public void setSearchData(String searchData) {
		this.searchData = searchData;
	}

	private String searchData;
	
	public String getErrorCode() {
		return "102";
	}
	public String getErrorMessage() {
		return "Data Not Found : "+searchData;
	}

}
