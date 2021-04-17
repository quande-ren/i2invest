package com.i2invest.domain.dto;

import java.sql.Timestamp;
import java.util.Date;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public  class ClubDto extends BaseDto{
	private   Long id;
	private   String name;
	private   String description;
	private   String contactEmail;
	private   String status;
	private   Date createTime;
	private   Date updateTime;
	
	private   Boolean publicVisible;


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Boolean getPublicVisible() {
		return publicVisible;
	}

	public void setPublicVisible(Boolean publicVisible) {
		this.publicVisible = publicVisible;
	}

	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
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

	private static final long serialVersionUID = -4926938619167517315L;

	public ClubDto(BaseDto fromCopy) {
		super(fromCopy);
	}

	public ClubDto() {}

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
}