package com.i2invest.ejb;

import com.i2invest.domain.request.BaseRequest;
import com.i2invest.ejb.processor.ForgotPasswordRequestProcessor;
import com.i2invest.ejb.processor.*;

public class RequestProcessorFactory {
	private static final AbstractRequestProcessor[] processors=new AbstractRequestProcessor[] {
			new SignUpRequestProcessor(),
			new SignInRequestProcessor(),
			new ForgotPasswordRequestProcessor(),
			new RetrieveUserRequestProcessor(),
			new ChangeProfileRequestProcessor(),
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
