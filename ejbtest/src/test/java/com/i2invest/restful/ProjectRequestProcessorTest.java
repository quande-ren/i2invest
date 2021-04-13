package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.PropertyDto;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.request.PropertyRequest;
import com.i2invest.domain.response.PropertyResponse;

public class ProjectRequestProcessorTest {

//	@Test
//	public void testCreate() throws NamingException, AppException {
//
//		FacadeService facadeService = TestUtil.getFacadeService();
//		
//		PropertyDto dto = new PropertyDto("2305 Houston ", "1230 units, 4.3% cap rate","2305 Hay Rd Houston");
//		dto.setProjectId(74L);
//		PropertyRequest request=new PropertyRequest(FileRequest.RequestType_Create, dto);
//		
//		PropertyResponse response=(PropertyResponse) facadeService.processRequest(request);
//		
//		assertNotNull(response.property);
//		assertNotNull(response.property.getName());
//		assertNotNull(response.property.getDescription());
//		assertNotNull(response.property.getId());
//		
//	}

	@Test
	public void testRetrieve() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		PropertyDto property=new PropertyDto();
		property.setProjectId(74L);
		PropertyRequest request=new PropertyRequest(ProjectRequest.RequestType_Retrieve);
		request.property=property;
		
		PropertyResponse response=(PropertyResponse) facadeService.processRequest(request);
		
		assertNotNull(response.properties);
		assertTrue(response.properties.length>0);
		for(PropertyDto f : response.properties) {
			assertNotNull(f.getId());
			assertNotNull(f.getName());
			assertNotNull(f.getDescription());
		}
	}
	
}
