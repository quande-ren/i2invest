package com.i2invest.domain.request;

import com.i2invest.domain.dto.UserDto;
import com.i2invest.domain.response.UserProfileUpdateResponse;

import lombok.Data;

@Data 
public class UserProfileUpdateRequest extends BaseRequest<UserProfileUpdateResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public UserDto user;
	public String oldPassword;
	public String newPassword;
//	public static final String RequestType_ChangeEmail="ChangeEmail";
	public static final String RequestType_ChangeProfile="ChangeProfile";
	public static final String RequestType_ChangePassword="ChangePassword";
	
	public UserProfileUpdateRequest() {
		
	}

	public UserProfileUpdateRequest(String email, String password) {
		this.email=email;
	}
	
	public  UserProfileUpdateResponse getDummayResponse() {
		return new UserProfileUpdateResponse();
	}
	
	@Override
	public String toString() {
	    return "ChangeProfileRequest( "
	    		+" email="+email
	    		+" token="+token
	    		+" user="+user
	    		+" oldPassword="+oldPassword
	    		+" newPassword="+newPassword
	    		+" requestType="+requestType;
	    
	}

}
