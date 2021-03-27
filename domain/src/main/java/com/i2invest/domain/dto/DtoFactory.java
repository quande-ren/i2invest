package com.i2invest.domain.dto;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.i2invest.domain.BaseDto;
import com.i2invest.domain.request.ChangeProfileRequest;
import com.i2invest.domain.request.ForgotPasswordRequest;
import com.i2invest.domain.request.PingRequest;
import com.i2invest.domain.request.RetrieveUserRequest;
import com.i2invest.domain.request.SignInRequest;
import com.i2invest.domain.request.SignUpRequest;

public class DtoFactory {
	private static final Logger logger=Logger.getLogger(DtoFactory.class.getName());
	
	private static final Gson gson = new Gson();
	private static Hashtable<String, Class> requestClassList=null;
	private static final Class[] requestClasses=new Class[] {
		ForgotPasswordRequest.class,
		PingRequest.class,
		RetrieveUserRequest.class,
		SignInRequest.class,
		SignUpRequest.class,
		ChangeProfileRequest.class
	};
	
	public static BaseDto getDto(String requestType, String json) {
		if(requestType==null) {
			throw new RuntimeException("requestType is not provided");
		}
		
		if(requestClassList==null) {
			requestClassList=new Hashtable<String, Class>() ;
			for(Class clazz : requestClasses) {
				String simpleName = clazz.getSimpleName();
				requestClassList.put(simpleName, clazz);
			}
		}
		
		Class clazz=requestClassList.get(requestType);
		if(clazz==null) {
			throw new RuntimeException("requestType of " + requestType + " not found");
		}
		
		return (BaseDto)gson.fromJson(json, clazz);
	}
}
