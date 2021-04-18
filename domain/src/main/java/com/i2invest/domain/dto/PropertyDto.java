package com.i2invest.domain.dto;

import java.util.Date;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public  class PropertyDto extends BaseDto{
	private   Long id;
	private   String name;
	private   Long projectId;
	private   String clubName;
	private   String projectName;
	private   String address;
	private   String description;
	private   String status;
	private   Date closingDate;
	private   Date createTime;
	private   Date updateTime;
	public    Long clubId;
	public    String num;
	public    String age;
	public    String units;
	public    String avgSf;
	public    String effRents;
	public    String effRentPerSf;
	public    String occupancy;

	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getClosingDate() {
		return closingDate;
	}

	public void setClosingDate(Date closingDate) {
		this.closingDate = closingDate;
	}


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

	public PropertyDto(BaseDto fromCopy) {
		super(fromCopy);
	}

	public PropertyDto() {}

	public PropertyDto(Long projectId) {
		this.projectId=projectId;
	}

	public PropertyDto(String name, String description, String address) {
		this.name=name;
		this.description=description;
		this.address=address;
	}

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

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public Long getClubId() {
		return clubId;
	}

	public void setClubId(Long clubId) {
		this.clubId = clubId;
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