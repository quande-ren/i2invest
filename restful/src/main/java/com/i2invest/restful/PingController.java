package com.i2invest.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api")
public class PingController {

	@GET
	@Path("/ping")
	public Response ping() {
		return Response.status(200).entity("SUCCESS").build();
	}

}