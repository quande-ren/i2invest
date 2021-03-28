package com.i2invest.ejb.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.i2invest.domain.BaseDto;

import lombok.Data;


@Data 
@Entity
@Table(name = "I2_UserClubRole")
public class UserClubRoleEjb extends BaseDto{
	private static final long serialVersionUID = -4926938619167517315L;

	public UserClubRoleEjb(BaseDto fromCopy) {
		copyPropertiesFrom(fromCopy);
	}


	public UserClubRoleEjb() {}
	
	@Id 
	@GeneratedValue
	@NotNull
	private   Long id;
	
	@ManyToOne
	@JoinColumn(name = "userId", nullable=false)
	private   UserEjb user;

	@ManyToOne
	@JoinColumn(name = "clubId", nullable=false)
	private   ClubEjb club;
	
	@ManyToOne
	@JoinColumn(name = "roleId", nullable=false)
	private   RoleEjb role;

	public ClubEjb getClub() {
		return club;
	}


	public void setClub(ClubEjb club) {
		this.club = club;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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

	private   String status;
	private   Timestamp createTime;
	private   Timestamp updateTime;
	
	
	public UserEjb getUser()
	{
	   return user;
	}
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public void setUser(UserEjb user) {
		this.user = user;
	}


	public RoleEjb getRole() {
		return role;
	}


	public void setRole(RoleEjb role) {
		this.role = role;
	}
}