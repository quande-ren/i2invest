package com.i2invest.ejb.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
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
@Table(name = "I2_User")
public class UserEjb extends BaseDto implements Serializable  {
	@Id 
	@GeneratedValue
	@NotNull
	private  Long id;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String email;
	@NotNull
	private String passwordHash;
	@NotNull
	private String phoneNum;
	
	@Column(name = "description",  length = 4000)
	private   String description;


	private Timestamp createTime;
	private Timestamp updateTime;
	private   Long createdBy;
	private   Long updatedBy;
	private   String calendly;
	private   String wechatId;
	private   String website;

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

	@OneToMany
	@JoinColumn(name="ownerId")
	private List<ClubEjb> clubsOwn;
	
	@OneToMany
	@JoinColumn(name="userId")
	private Set<UserClubRoleEjb> clubRoles;
	
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

	public UserEjb() {
	}

	public UserEjb(String firstName, String email) {

		this.setFirstName(firstName);
		this.email = email;
	}

	
	public Long getId() {
		return this.id;
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

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Set<UserClubRoleEjb> getClubRoles() {
		return clubRoles;
	}

	public void setClubRoles(Set<UserClubRoleEjb> clubRoles) {
		this.clubRoles = clubRoles;
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

	public List<ClubEjb> getClubsOwn() {
		return clubsOwn;
	}

	public void setClubsOwn(List<ClubEjb> clubsOwn) {
		this.clubsOwn = clubsOwn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}