package com.i2invest.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.i2invest.domain.BaseDto;

@Entity
@Table(name = "I2_Role")
public class RoleEjb extends BaseDto{

	private static final long serialVersionUID = 5752744043687408583L;
	
	@Id 
	@NotNull
	private   String id;
	
	private   String roleType;
	private   String roleName;
	private   String status;
	private   Timestamp createTime;
	private   Timestamp updateTime;

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

	public RoleEjb(BaseDto fromCopy) {
		super(fromCopy);
	}

	public RoleEjb() {}

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