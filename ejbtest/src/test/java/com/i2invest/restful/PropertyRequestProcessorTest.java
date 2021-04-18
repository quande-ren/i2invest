package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.PropertyDto;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.request.PropertyRequest;
import com.i2invest.domain.response.PropertyResponse;

public class PropertyRequestProcessorTest {

	@Test
	public void testRetrieve() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		PropertyDto property=new PropertyDto(161L);
		PropertyRequest request=new PropertyRequest(ProjectRequest.RequestType_Retrieve, property);
		
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
