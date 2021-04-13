package com.i2invest.ejb.processor;

import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.ProjectDto;
import com.i2invest.domain.dto.PropertyDto;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.request.ProjectRequest;
import com.i2invest.domain.request.PropertyRequest;
import com.i2invest.domain.response.ProjectResponse;
import com.i2invest.domain.response.PropertyResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.ProjectEjb;
import com.i2invest.ejb.entity.PropertyEjb;
import com.i2invest.ejb.entity.UserEjb;

public class PropertyRequestProcessor extends AbstractRequestProcessor<PropertyRequest, PropertyResponse> {
	public void process(EntityManager entityManager, PropertyRequest request, PropertyResponse response, UserEjb currentUserEjb) throws AppException{
		if(FileRequest.RequestType_Create.equals(request.requestType)) {
			ProjectEjb projectEjb=entityManager.find(ProjectEjb.class, request.property.getProjectId());
			PropertyEjb propertyEjb=new PropertyEjb(request.property);
			propertyEjb.setId(null);
			propertyEjb.setProject(projectEjb);
			entityManager.persist(propertyEjb);
			response.property=new PropertyDto(propertyEjb);
			response.property.setId(propertyEjb.getId());
		}else if(ProjectRequest.RequestType_Retrieve.equals(request.requestType)) {
			ProjectEjb projectEjb=entityManager.find(ProjectEjb.class, request.property.getProjectId());
			List<PropertyEjb> ejbs=projectEjb.getProperties();
			if(ejbs!=null) {
				PropertyDto[] result = new PropertyDto[ejbs.size()];
				int i=0;
				for(PropertyEjb ejb: ejbs) {
					result[i]=new PropertyDto(ejb);
					result[i].setClubName(ejb.getProject().getName());
					i++;
				}
				
				response.properties=result;
			}
		}
	}

	public void verifyData(ProjectRequest request) throws MissingParameterException {
		if(request==null) {
			throw new MissingParameterException("request");
		}
		
		if(FileRequest.RequestType_Create.equals(request.requestType)) {
			if(request.project==null) {
				throw new MissingParameterException("request.project");
			}
			if(request.project.getClubId()==null) {
				throw new MissingParameterException("request.project.clubId");
			}
			if(request.project.getName()==null) {
				throw new MissingParameterException("request.project.name");
			}
			if(request.project.getDescription()==null) {
				throw new MissingParameterException("request.project.description");
			}
		}
	}
	
}
