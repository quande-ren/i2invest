package com.i2invest.domain.dto;

import java.sql.Timestamp;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public  class RoleDto extends BaseDto{

	private static final long serialVersionUID = 5752744043687408583L;
	private   String id;
	private   String roleType;
	private   String roleName;
	private   String status;
	private   Timestamp createTime;
	private   Timestamp updateTime;
	
	public static final String ROLE_CLUB_STARTER="CLUB_STARTER";
	public static final String ROLE_CLUB_APPLY="CLUB_APPLY";
	public static final String ROLE_CLUB_ACTIVE="CLUB_ACTIVE";
	public static final String ROLE_CLUB_REJECTED="CLUB_REJECTED";

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

	public RoleDto(BaseDto fromCopy) {
		super(fromCopy);
	}

	public RoleDto() {}

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}