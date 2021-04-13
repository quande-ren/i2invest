package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ProjectDto;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.response.ProjectResponse;

public class PropertyRequestProcessorTest {

	@Test
	public void testCreate() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		ProjectDto dto = new ProjectDto("2305 Houston ", "1230 units, 4.3% cap rate","2305 Hay Rd Houston");
		ProjectRequest request=new ProjectRequest(FileRequest.RequestType_Create, dto);
		
		ProjectResponse response=(ProjectResponse) facadeService.processRequest(request);
		
		assertNotNull(response.project);
		assertNotNull(response.project.getName());
		assertNotNull(response.project.getDescription());
		assertNotNull(response.project.getId());
		
	}

	@Test
	public void testRetrieve() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		ProjectRequest request=new ProjectRequest(ProjectRequest.RequestType_Retrieve);
		
		ProjectResponse response=(ProjectResponse) facadeService.processRequest(request);
		
		assertNotNull(response.projects);
		assertTrue(response.projects.length>0);
		for(ProjectDto f : response.projects) {
			assertNotNull(f.getId());
			assertNotNull(f.getName());
			assertNotNull(f.getDescription());
		}
	}
	
}
