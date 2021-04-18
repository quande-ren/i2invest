package com.i2invest.ejb.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private   Date createTime;
	private   Date updateTime;
	private   String address;
	private   Date closingDate;
	public    String num;
	public    String age;
	public    String units;
	public    String avgSf;
	public    String effRents;
	public    String effRentPerSf;
	public    String occupancy;

	
	@ManyToOne
	@JoinColumn(name = "projectId", nullable=false)
	private   ProjectEjb project;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getAvgSf() {
		return avgSf;
	}

	public void setAvgSf(String avgSf) {
		this.avgSf = avgSf;
	}

	public String getEffRents() {
		return effRents;
	}

	public void setEffRents(String effRents) {
		this.effRents = effRents;
	}

	public String getEffRentPerSf() {
		return effRentPerSf;
	}

	public void setEffRentPerSf(String effRentPerSf) {
		this.effRentPerSf = effRentPerSf;
	}

	public String getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(String occupancy) {
		this.occupancy = occupancy;
	}

	
}