package com.i2invest.domain.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public  class PropertyDto extends BaseDto{
	private   Long id;
	private   String name;
	private   Long projectId;
	private   String clubName;
	private   String projectName;
	private   String address;
	private   String description;
	private   String status;
	private   Date closingDate;
	private   Timestamp createTime;
	private   Timestamp updateTime;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	private static final long serialVersionUID = -4926938619167517315L;

	public PropertyDto(BaseDto fromCopy) {
		super(fromCopy);
	}

	public PropertyDto() {}

	public PropertyDto(Long projectId) {
		this.projectId=projectId;
	}

	public PropertyDto(String name, String description, String address) {
		this.name=name;
		this.description=description;
		this.address=address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}