package com.i2invest.domain.request;

import com.i2invest.domain.dto.ProjectDto;
import com.i2invest.domain.response.ProjectResponse;

import lombok.Data;

@Data
public  class ProjectRequest extends BaseRequest<ProjectResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public ProjectDto project;
	
	public ProjectRequest() {
	}
	public ProjectRequest(String requestType) {
		this.requestType=requestType;
	}

	public ProjectRequest(String requestType, ProjectDto project ) {
		this.requestType=requestType;
		this.project=project;
	}

	public  ProjectResponse getDummayResponse() {
		return new ProjectResponse();
	}

}
