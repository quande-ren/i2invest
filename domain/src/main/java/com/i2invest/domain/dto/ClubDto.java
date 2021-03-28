package com.i2invest.domain.dto;

import java.sql.Timestamp;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public  class ClubDto extends BaseDto{
	private   Long id;
	private   String clubName;
	private   String contactEmail;
	private   String status;
	private   Timestamp createTime;
	private   Timestamp updateTime;

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
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

	public ClubDto(BaseDto fromCopy) {
		super(fromCopy);
	}

	public ClubDto() {}
}