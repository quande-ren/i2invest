package com.i2invest.restful;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.DtoJsonWrapper;
import com.i2invest.domain.request.BaseRequest;
import com.i2invest.domain.response.BaseResponse;

@Path("/api")
public class RestServiceController {

	private FacadeService facadeService;
	private Context context;

	@POST
    @Path("/postJson3")
    @Produces("application/json")
	@Consumes("application/json")
	public BaseResponse processRequest(DtoJsonWrapper dto ) throws NamingException {
		if(facadeService==null) {
			getFacadeService();
		};
		
		BaseRequest payloadRequest=(BaseRequest) dto.getPayloadDto();

		try {
			BaseResponse response=facadeService.processRequest(payloadRequest);
			return response;
		} catch (AppException e) {
			return new BaseResponse(e.getErrorCode(), e.getErrorMessage());
		}
	}

	private void getFacadeService() throws NamingException {
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
		final Context context = new InitialContext(jndiProperties);

		facadeService = (FacadeService) context.lookup("ejb:i2invest_ear/com.i2invest-ejb-0.0.1/FacadeEjb!com.i2invest.domain.FacadeService");
	}

}