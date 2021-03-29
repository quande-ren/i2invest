package com.i2invest.ejb.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data 
@Entity
@Table(name = "I2_Club")
public class ClubEjb extends BaseDto{
	@Id 
	@GeneratedValue
	@NotNull
	private   Long id;
	private   String clubName;
	private   String description;
	private   String contactEmail;
	private   String status;
	private   Timestamp createTime;
	private   Timestamp updateTime;
	
	@OneToMany
	@JoinColumn(name="clubId")
	private List<UserClubRoleEjb> userRoles;


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

	public ClubEjb(BaseDto fromCopy) {
		super(fromCopy);
	}

	public ClubEjb() {}

	public List<UserClubRoleEjb> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserClubRoleEjb> userRoles) {
		this.userRoles = userRoles;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}