package com.i2invest.domain.dto;

import java.sql.Timestamp;

import com.i2invest.domain.BaseDto;

import lombok.Data;


@Data
public  class UserDto extends BaseDto{
	private static final long serialVersionUID = -4926938619167517315L;

	public UserDto(BaseDto fromCopy) {
		copyPropertiesFrom(fromCopy);
	}


	public UserDto() {}
	
	public UserDto(String firstName, String email) {
		this.firstName=firstName;
		this.email=email;
	}

	public UserDto(String firstName, String lastName, String email) {
		this.firstName=firstName;
		this.email=email;
		this.lastName=lastName;
	}

	private   Long id;
	private   String firstName;
	private   String lastName;
	private   String clubName;
	private   String projectName;
	private   String email;
	private   String password;
	private   String phoneNum;
	private   String description;
	private   String status;
	private   String calendly;
	private   String wechatId;
	private   String website;
	

	private Timestamp createTime;

	private Timestamp updateTime;

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCalendly() {
		return calendly;
	}


	public void setCalendly(String calendly) {
		this.calendly = calendly;
	}


	public String getWechatId() {
		return wechatId;
	}


	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
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

	public String getPasswordHash() {
		return (email+"."+password).hashCode()+"";
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}


	public String getClubName() {
		return clubName;
	}


	public void setClubName(String clubName) {
		this.clubName = clubName;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

}