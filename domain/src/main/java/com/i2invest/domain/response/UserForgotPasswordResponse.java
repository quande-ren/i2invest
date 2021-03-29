package com.i2invest.domain.response;

import lombok.Data;

@Data
public  class UserForgotPasswordResponse extends BaseResponse {
	public String newPassword;

	public UserForgotPasswordResponse() {
	}

	public UserForgotPasswordResponse(String newPw) {
		this.newPassword = newPw;
	}

}
