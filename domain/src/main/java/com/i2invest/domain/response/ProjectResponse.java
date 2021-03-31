package com.i2invest.domain.response;

import com.i2invest.domain.dto.ProjectDto;

import lombok.Data;

@Data
public  class ProjectResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public ProjectDto project;
	public ProjectDto[] projects;
	public ProjectResponse() {
	}

	public ProjectResponse(ProjectDto project) {
		this.project=project;
	}

	public ProjectResponse(ProjectDto[] projects) {
		this.projects=projects;
	}

	
}
