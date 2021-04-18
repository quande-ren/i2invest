package com.i2invest.ejb.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.i2invest.domain.BaseDto;

@Entity
@Table(name = "I2_Club")
public class ClubEjb extends BaseDto{
	
	private static final long serialVersionUID = -4926938619167517315L;

	@Id 
	@GeneratedValue
	@NotNull
	private   Long id;

	private   String name;
	
	@Column(name = "description",  length = 4000)
	private   String description;

	private   String contactEmail;
	
	private   String status;

	private   Boolean publicVisible;

	private   Long createdBy;
	
	private   Long updatedBy;
	
	private   Date createTime;
	
	private   Date updateTime;
	
	@OneToMany
	@JoinColumn(name = "clubId")
	private List<UserClubRoleEjb> userRoles;

	@OneToMany
	@JoinColumn(name = "clubId")
	private List<ProjectEjb> projects;

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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public List<ProjectEjb> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEjb> projects) {
		this.projects = projects;
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
	
	@Override
	public String toString() {
		return "ClubEjb[ name="+this.name+" "+this.contactEmail+" "+this.description+" "+this.status+" "+this.publicVisible+" numberOfUserRoles="+(this.getUserRoles()==null?0:this.getUserRoles().size())+" ]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
}