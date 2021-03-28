package com.i2invest.domain.request;

import com.i2invest.domain.UserDto;
import com.i2invest.domain.response.ChangeProfileResponse;

import lombok.Data;

@Data 
public class ChangeProfileRequest extends BaseRequest<ChangeProfileResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public UserDto user;
	public String oldPassword;
	public String newPassword;
	public boolean changeEmailOnly=false;
	public boolean changeProfileOnly=false;
	public boolean changePasswordOnly=false;
	
	public ChangeProfileRequest() {
		
	}

	public ChangeProfileRequest(String email, String password) {
		this.email=email;
	}
	
	public  ChangeProfileResponse getDummayResponse() {
		return new ChangeProfileResponse();
	}
	
	@Override
	public String toString() {
	    return "ChangeProfileRequest( "
	    		+" email="+email
	    		+" token="+token
	    		+" user="+user
	    		+" oldPassword="+oldPassword
	    		+" newPassword="+newPassword
	    		+" changeEmailOnly="+changeEmailOnly
	    		+" changeProfileOnly="+changeProfileOnly
	    		+" changePasswordOnly="+changePasswordOnly+")";
	}

}
