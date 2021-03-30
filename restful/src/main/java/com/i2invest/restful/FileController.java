package com.i2invest.restful;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

@Path("/fileapi")
public class FileController {
	/**
	 * Access this service using link of https://wsldw02.tmmc.na.corp.toyota.com:8443/i2invest/fileapi/aaa/text
	 * @param fileName
	 * @return
	 */
	@GET
    @Path("/{fileName}/text")
    @Produces("text/plain")
    public Response getFileInTextFormat(@PathParam("fileName") String fileName) {
		System.out.println("File requested is : " + fileName);

		// Put some validations here such as invalid file name or missing file name
		if (fileName == null || fileName.isEmpty()) {
			 ResponseBuilder response = Response.status(Status.BAD_REQUEST);
	         return response.build();
		}

		// Prepare a file object with file to return
		File file = new File("c:/temp/a.txt");

		ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition", "attachment; filename=\"howtodoinjava.txt\"");
		return response.build();
	}

}
