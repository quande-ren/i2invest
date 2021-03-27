package com.i2invest.ejb;

import static javax.ejb.TransactionAttributeType.REQUIRED;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Logger;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.TokenIsNotProvidedException;
import com.i2invest.domain.appexception.TokenIsNotValidException;
import com.i2invest.domain.request.BaseRequest;
import com.i2invest.domain.response.BaseResponse;
import com.i2invest.util.JwtUtil;

@Stateless
@TransactionAttribute(REQUIRED)
@Remote(FacadeService.class)
public class FacadeEjb implements FacadeService {
	private static final Logger logger=Logger.getLogger(FacadeEjb.class.getName());
	public void sayHelloFromServiceBean() {
		logger.info("Hello From Service Bean!");
	}
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager entityManager;

	@Override
	public BaseResponse processRequest(BaseRequest request) throws AppException {
		AbstractRequestProcessor processor = RequestProcessorFactory.getProcessor(request);
		
		if(processor.requireToken()) {
			if(request.email==null || request.token==null) {
				throw new TokenIsNotProvidedException();
			}
			if( ! JwtUtil.isValidToken(request.token, request.email)) {
				throw new TokenIsNotValidException();
			}
		}
		
		processor.verifyData(request);
		
		BaseResponse response= request.getDummayResponse();
		
		processor.process(entityManager, request, response);

		logger.info("\n\n\nRequest is\n"+request+"\n\nResponse is\n"+response+"\n");
		
		return response;
	}
}
