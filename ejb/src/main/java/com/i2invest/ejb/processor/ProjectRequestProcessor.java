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
import com.i2invest.ejb.entity.ClubEjb;
import com.i2invest.ejb.entity.ProjectEjb;
import com.i2invest.ejb.entity.UserEjb;

public class ProjectRequestProcessor extends AbstractRequestProcessor<ProjectRequest, ProjectResponse> {
	public void process(EntityManager entityManager, ProjectRequest request, ProjectResponse response, UserEjb currentUserEjb) throws AppException{
		if(FileRequest.RequestType_Create.equals(request.requestType)) {
			ClubEjb clubEjb=entityManager.find(ClubEjb.class, request.project.getClubId());
			ProjectEjb ejb=new ProjectEjb(request.project);
			ejb.setId(null);
			ejb.setClub(clubEjb);
			entityManager.persist(ejb);
			response.project=new ProjectDto(ejb);
			response.project.setId(ejb.getId());
		}else if(ProjectRequest.RequestType_Retrieve.equals(request.requestType)) {
			ClubEjb club=ClubRetrieveRequestProcessor.retrieveClubEjb(entityManager, request.project.getClubId());
			List<ProjectEjb> ejbs=club.getProjects();//entityManager.createQuery("from ProjectEjb p", ProjectEjb.class).getResultList();
			if(ejbs!=null) {
				ProjectDto[] result = new ProjectDto[ejbs.size()];
				int i=0;
				for(ProjectEjb ejb: ejbs) {
					result[i]=new ProjectDto(ejb);
					result[i].setClubName(ejb.getClub().getName());
					result[i].setClubId(ejb.getClub().getId());
					i++;
				}
				
				response.projects=result;
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
		if(FileRequest.RequestType_Retrieve.equals(request.requestType)) {
			if(request.project==null) {
				throw new MissingParameterException("request.project");
			}
			if(request.project.getClubId()==null) {
				throw new MissingParameterException("request.project.clubId");
			}
		}
	}
	
}
