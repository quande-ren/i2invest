package com.i2invest.ejb.entity;

import java.sql.Timestamp;
import java.util.List;

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
@Table(name = "I2_Property")
public class PropertyEjb extends BaseDto{
	@Id 
	@GeneratedValue
	@NotNull
	private   Long id;
	private   String name;
	private   String description;
	private   String status;
	private   Long createdBy;
	private   Long updatedBy;
	private   Timestamp createTime;
	private   Timestamp updateTime;
	@ManyToOne
	@JoinColumn(name = "projectId", nullable=false)
	private   ProjectEjb project;
	
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

	public PropertyEjb(BaseDto fromCopy) {
		super(fromCopy);
	}

	public PropertyEjb() {}

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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public ProjectEjb getProject() {
		return project;
	}

	public void setProject(ProjectEjb project) {
		this.project = project;
	}


	
}