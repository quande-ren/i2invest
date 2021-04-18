package com.i2invest.ejb.processor;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.appexception.NameAlreadyExistException;
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
			createRecord(entityManager, request, response);
		}else if(ProjectRequest.RequestType_Update.equals(request.requestType)) {
			updateRecord(entityManager, request, response);
		}else if(ProjectRequest.RequestType_Retrieve.equals(request.requestType)) {
			retrieveRecords(entityManager, request, response);
		}else {
			throw new RuntimeException("Not recognized request type:"+request.requestType);
		}
	}

	private void updateRecord(EntityManager entityManager, ProjectRequest request, ProjectResponse response) throws NameAlreadyExistException {
		checkProjectNameNotExists(entityManager, request.project.getName(), request.project.getId(), request.project.getClubId());
		ClubEjb clubEjb=entityManager.find(ClubEjb.class, request.project.getClubId());
		ProjectEjb ejb=entityManager.find(ProjectEjb.class, request.project.getId());
		ejb.setName(request.project.getName());
		ejb.setDescription(request.project.getDescription());
		ejb.setContactEmail(request.project.getContactEmail());
		ejb.setUpdateTime(new Date());
		entityManager.persist(ejb);
		response.project=new ProjectDto(ejb);
		response.project.setId(ejb.getId());
	}

	private void retrieveRecords(EntityManager entityManager, ProjectRequest request, ProjectResponse response) throws NameAlreadyExistException {
		
		ClubEjb club=ClubRetrieveRequestProcessor.retrieveClubEjb(entityManager, request.project.getClubId());
		List<ProjectEjb> ejbs=club.getProjects();
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

	private void createRecord(EntityManager entityManager, ProjectRequest request, ProjectResponse response) throws NameAlreadyExistException {
		checkProjectNameNotExists(entityManager, request.project.getName(), request.project.getId(), request.project.getClubId());
		ClubEjb clubEjb=entityManager.find(ClubEjb.class, request.project.getClubId());
		ProjectEjb ejb=new ProjectEjb(request.project);
		ejb.setId(null);
		ejb.setClub(clubEjb);
		entityManager.persist(ejb);
		response.project=new ProjectDto(ejb);
		response.project.setId(ejb.getId());
	}
	
	public static void checkProjectNameNotExists(EntityManager entityManager, String name, Long id, Long clubId) throws NameAlreadyExistException {
		String sql=null;
		if(id!=null && id.longValue()>0L) {
			sql="select count(*) from i2_project where clubid="+clubId+" and upper(name)='"+name.toUpperCase()+"' and id <>"+id;
		}else {
			sql="select count(*) from i2_project where clubid="+clubId+" and upper(name)='"+name.toUpperCase()+"'";
		}
		Query q=entityManager.createNativeQuery(sql);
		Number result=(Number) q.getSingleResult();
		if(result!=null && result.intValue()>0) {
			throw new NameAlreadyExistException(name);
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
