package com.i2invest.ejb.processor;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.ConfigDto;
import com.i2invest.domain.request.ConfigRequest;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.response.ConfigResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.ConfigEjb;
import com.i2invest.ejb.entity.UserEjb;

public class ConfigRequestProcessor extends AbstractRequestProcessor<ConfigRequest, ConfigResponse> {
	public void process(EntityManager entityManager, ConfigRequest request, ConfigResponse response, UserEjb currentUserEjb) throws AppException{
		if(FileRequest.RequestType_Create.equals(request.requestType)) {
			ConfigEjb ejb=new ConfigEjb(request.config);
			ejb.setId(null);
			ejb.setCreateTime(new Date());
			ejb.setUpdateTime(ejb.getCreateTime());
			entityManager.persist(ejb);
			response.config=new ConfigDto(ejb);
			response.config.setId(ejb.getId());
		}else if(ProjectRequest.RequestType_Retrieve.equals(request.requestType)) {
			List<ConfigEjb> ejbs=entityManager.createQuery("from ConfigEjb p", ConfigEjb.class).getResultList();
			if(ejbs!=null) {
				ConfigDto[] result = new ConfigDto[ejbs.size()];
				int i=0;
				for(ConfigEjb ejb: ejbs) {
					result[i]=new ConfigDto(ejb);
					i++;
				}
				
				response.configs=result;
			}
		}
	}

	public void verifyData(ProjectRequest request) throws MissingParameterException {
	}
	
}
