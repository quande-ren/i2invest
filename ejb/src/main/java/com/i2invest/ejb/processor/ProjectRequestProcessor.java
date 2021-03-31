package com.i2invest.ejb.processor;

import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.ProjectDto;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.response.ProjectResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.ProjectEjb;

public class ProjectRequestProcessor extends AbstractRequestProcessor<ProjectRequest, ProjectResponse> {
	public void process(EntityManager entityManager, ProjectRequest request, ProjectResponse response) throws AppException{
		if(FileRequest.RequestType_Create.equals(request.requestType)) {
			ProjectEjb ejb=new ProjectEjb(request.project);
			entityManager.persist(ejb);
			response.project=new ProjectDto(ejb);
			response.project.setId(ejb.getId());
		}else if(ProjectRequest.RequestType_Retrieve.equals(request.requestType)) {
			List<ProjectEjb> ejbs=entityManager.createQuery("from ProjectEjb p", ProjectEjb.class).getResultList();
			if(ejbs!=null) {
				ProjectDto[] result = new ProjectDto[ejbs.size()];
				int i=0;
				for(ProjectEjb ejb: ejbs) {
					result[i]=new ProjectDto(ejb);
					i++;
				}
				
				response.projects=result;
			}
		}
	}

	public void verifyData(ProjectRequest request) throws MissingParameterException {
	}
	
}
