package com.i2invest.domain.response;

import lombok.Data;

public @Data class ForgotPasswordResponse extends BaseResponse {
	public String newPassword;

	public ForgotPasswordResponse() {
	}

	public ForgotPasswordResponse(String newPw) {
		this.newPassword = newPw;
	}

}
