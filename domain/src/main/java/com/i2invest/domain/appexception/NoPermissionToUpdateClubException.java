package com.i2invest.domain.appexception;

import lombok.Data;

@Data
public class NoPermissionToUpdateClubException extends AppException{
	public NoPermissionToUpdateClubException(String searchData) {
		this.searchData=searchData;
	}
	public NoPermissionToUpdateClubException() {
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
		return "No Permission To Update";
	}

}
