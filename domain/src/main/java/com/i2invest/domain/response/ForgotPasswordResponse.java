package com.i2invest.domain.response;

import lombok.Data;

@Data
public  class ForgotPasswordResponse extends BaseResponse {
	public String newPassword;

	public ForgotPasswordResponse() {
	}

	public ForgotPasswordResponse(String newPw) {
		this.newPassword = newPw;
	}

}
