package com.i2invest.domain.request;

import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.response.UserProfileChangeResponse;

import lombok.Data;

@Data 
public class UserProfileChangeRequest extends BaseRequest<UserProfileChangeResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public UserDto user;
	public String oldPassword;
	public String newPassword;
	public boolean changeEmailOnly=false;
	public boolean changeProfileOnly=false;
	public boolean changePasswordOnly=false;
	
	public UserProfileChangeRequest() {
		
	}

	public UserProfileChangeRequest(String email, String password) {
		this.email=email;
	}
	
	public  UserProfileChangeResponse getDummayResponse() {
		return new UserProfileChangeResponse();
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
