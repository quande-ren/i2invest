package com.i2invest.ejb;

import com.i2invest.domain.request.BaseRequest;
import com.i2invest.ejb.processor.*;

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
