package com.i2invest.ejb;

import com.i2invest.domain.request.BaseRequest;
import com.i2invest.ejb.processor.ClubJoinRequestProcessor;
import com.i2invest.ejb.processor.ClubRequestProcessor;
import com.i2invest.ejb.processor.ClubRetrieveRequestProcessor;
import com.i2invest.ejb.processor.ClubStartRequestProcessor;
import com.i2invest.ejb.processor.ClubUpdateRequestProcessor;
import com.i2invest.ejb.processor.ConfigRequestProcessor;
import com.i2invest.ejb.processor.FileRequestProcessor;
import com.i2invest.ejb.processor.ProjectRequestProcessor;
import com.i2invest.ejb.processor.UserForgotPasswordRequestProcessor;
import com.i2invest.ejb.processor.UserProfileChangeRequestProcessor;
import com.i2invest.ejb.processor.UserRetrieveRequestProcessor;
import com.i2invest.ejb.processor.UserSignInRequestProcessor;
import com.i2invest.ejb.processor.UserSignUpRequestProcessor;

public class RequestProcessorFactory {
	private static final AbstractRequestProcessor[] processors=new AbstractRequestProcessor[] {
			new UserSignUpRequestProcessor(),
			new UserSignInRequestProcessor(),
			new UserForgotPasswordRequestProcessor(),
			new UserRetrieveRequestProcessor(),
			new UserProfileChangeRequestProcessor(),
			new ClubStartRequestProcessor(),
			new ClubRetrieveRequestProcessor(),
			new ClubJoinRequestProcessor(),
			new ClubUpdateRequestProcessor(),
			new FileRequestProcessor(),
			new ProjectRequestProcessor(),
			new ClubRequestProcessor(),
			new ConfigRequestProcessor(),
	};
	
	public static AbstractRequestProcessor getProcessor(BaseRequest request) {
		String requestName = request.getClass().getSimpleName();
		for(AbstractRequestProcessor processor: processors) {
			if(processor.getClass().getSimpleName().startsWith(requestName)) {
				return processor;
			}
		}
		throw new RuntimeException("Processor not found for "+request.getClass().getName());
	}
}
