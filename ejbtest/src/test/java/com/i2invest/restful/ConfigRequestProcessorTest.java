package com.i2invest.restful;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.naming.NamingException;

import org.junit.Test;

import com.i2invest.domain.FacadeService;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.dto.ConfigDto;
import com.i2invest.domain.dto.ProjectDto;
import com.i2invest.domain.request.ConfigRequest;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.response.ConfigResponse;
import com.i2invest.domain.response.ProjectResponse;

public class ConfigRequestProcessorTest {

//	@Test
	public void testCreate() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		ConfigDto dto = new ConfigDto();
		dto.setStatus("ACTIVE");
		dto.setTableName("I2_USER_INFO");
		dto.setFieldName("INFO_TYPE");
//		dto.setFieldValue("WECHAT_ID");
//		dto.setDescription("WeChat ID");

		dto.setFieldValue("WEBSITE");
		dto.setDescription("Web Site");

		ConfigRequest request=new ConfigRequest(FileRequest.RequestType_Create, dto);
		
		ConfigResponse response=(ConfigResponse) facadeService.processRequest(request);
		
		assertNotNull(response.config);
		assertNotNull(response.config.getId());
		
	}

	@Test
	public void testRetrieve() throws NamingException, AppException {

		FacadeService facadeService = TestUtil.getFacadeService();
		
		ConfigRequest request=new ConfigRequest(ConfigRequest.RequestType_Retrieve);
		
		ConfigResponse response=(ConfigResponse) facadeService.processRequest(request);
		
		assertNotNull(response.configs);
		assertTrue(response.configs.length>0);
		for(ConfigDto f : response.configs) {
			assertNotNull(f.getId());
			
			System.out.println(f);
		}
	}
	
}
