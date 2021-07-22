package com.i2invest.restful;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.i2invest.domain.DtoJsonWrapper;
import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.BaseRequest;
import com.i2invest.domain.response.BaseResponse;

@Path("/api")
public class RestServiceController {
	private static final Logger logger=Logger.getLogger(RestServiceController.class.getName());

	private FacadeService facadeService;

	@POST
    @Path("/postJson3")
    @Produces("application/json")
	@Consumes("application/json")
	public BaseResponse processRequest(DtoJsonWrapper dto ) throws NamingException {
		if(facadeService==null) {
			prepareFacadeService();
		};

		logger.info("Received dto="+dto);
		
		
		BaseRequest payloadRequest=(BaseRequest) dto.getPayloadDto();
		logger.info("Request Type="+dto.type+" Payload="+ dto.jsonString+"\nPayload Request="+payloadRequest);

		try {
			BaseResponse response=facadeService.processRequest(payloadRequest);
			return response;
		} catch (AppException e) {
			return new BaseResponse(e.getErrorCode(), e.getErrorMessage());
		} catch (RuntimeException e) {
			return new BaseResponse("100", e.getMessage());
		}
	}

	private void prepareFacadeService() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		facadeService = (FacadeService) context.lookup("ejb:i2invest_ear/com.i2invest-ejb-0.0.1/FacadeEjb!com.i2invest.domain.FacadeService");
	}

}