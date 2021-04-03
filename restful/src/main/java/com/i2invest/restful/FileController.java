package com.i2invest.restful;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;
import org.jboss.resteasy.plugins.providers.multipart.InputPart;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

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
    public Response downloadTextFile(@PathParam("fileName") String fileName) {
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
	
	private final String UPLOADED_FILE_PATH = "c:/temp/";

	@POST
    @Path("/fileUpload")
    @Consumes({  MediaType.MEDIA_TYPE_WILDCARD})
    public Response uploadFile(MultipartFormDataInput input) throws IOException 
    {
		 System.out.println("In uploadFile....");
        //Get API input data
        Map<String, List<InputPart>> uploadForm = input.getFormDataMap();
         
        //Get file name
        InputPart inputPart = uploadForm.values().iterator().next().iterator().next();
         
        String fileName = UPLOADED_FILE_PATH + getFileName(inputPart.getHeaders());
            try
            {
                InputStream inputStream = inputPart.getBody(InputStream.class, null);
                 
                byte[] bytes = IOUtils.toByteArray(inputStream);
                // constructs upload file path
	            writeFile(bytes, fileName);
                System.out.println("Success !!!!! "+fileName);
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }

            return Response.status(200)
                .entity("Uploaded file name : "+ fileName).build();
    }
	
	
	private String getFileName(MultivaluedMap<String, String> header) {

        String[] contentDisposition = header.getFirst("Content-Disposition").split(";");
        
        for (String filename : contentDisposition) {
            if ((filename.trim().startsWith("filename"))) {

                String[] name = filename.split("=");
                
                String finalFileName = name[1].trim().replaceAll("\"", "");
                return finalFileName;
            }
        }
        return "unknown";
    }
	
	
	 //Utility method
    private void writeFile(byte[] content, String filename) throws IOException 
    {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fop = new FileOutputStream(file);
        fop.write(content);
        fop.flush();
        fop.close();
    }
	
}
