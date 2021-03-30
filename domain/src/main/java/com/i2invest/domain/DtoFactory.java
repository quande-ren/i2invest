package com.i2invest.domain;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.i2invest.domain.request.ClubJoinRequest;
import com.i2invest.domain.request.ClubRetrieveRequest;
import com.i2invest.domain.request.ClubStartRequest;
import com.i2invest.domain.request.ClubUpdateRequest;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.PingRequest;
import com.i2invest.domain.request.UserForgotPasswordRequest;
import com.i2invest.domain.request.UserProfileChangeRequest;
import com.i2invest.domain.request.UserRetrieveRequest;
import com.i2invest.domain.request.UserSignInRequest;
import com.i2invest.domain.request.UserSignUpRequest;

public class DtoFactory {
	private static final Logger logger=Logger.getLogger(DtoFactory.class.getName());
	
	private static final Gson gson = new Gson();
	private static Hashtable<String, Class> requestClassList=null;
	private static final Class[] requestClasses=new Class[] {
		UserForgotPasswordRequest.class,
		PingRequest.class,
		UserRetrieveRequest.class,
		UserSignInRequest.class,
		UserSignUpRequest.class,
		UserProfileChangeRequest.class,
		ClubStartRequest.class,
		ClubRetrieveRequest.class,
		ClubJoinRequest.class,
		ClubUpdateRequest.class,
		FileRequest.class,
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
