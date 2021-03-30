package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.FileDto;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.response.FileResponse;

public class FileRequestProcessorTest {

//	@Test
//	public void testCreate() throws NamingException, AppException {
//
//		FacadeService facadeService = TestUtil.getFacadeService();
//		
//		FileDto file = new FileDto("abbb.txt","text","aaannna".getBytes());
//		FileRequest request=new FileRequest(FileRequest.RequestType_Create, file);
//		
//		
//		FileResponse response=(FileResponse) facadeService.processRequest(request);
//		
//		assertNotNull(response.file);
//		assertNotNull(response.file.getName());
//		assertNotNull(response.file.getType());
////		assertNotNull(response.file.getId());
//		
//	}

	@Test
	public void testRetrieve() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
//		FileDto file = new FileDto("abbb.txt","text","aaannna".getBytes());
		FileRequest request=new FileRequest(FileRequest.RequestType_RetrieveWithoutData);
		
		
		FileResponse response=(FileResponse) facadeService.processRequest(request);
		
		assertNotNull(response.files);
		assertTrue(response.files.length>0);
		for(FileDto f : response.files) {
			assertNotNull(f.getId());
			assertNotNull(f.getName());
			assertNotNull(f.getType());
		}
	}
	
}
