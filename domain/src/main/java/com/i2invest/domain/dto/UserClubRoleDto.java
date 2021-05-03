package com.i2invest.domain.dto;

import java.sql.Timestamp;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public class UserClubRoleDto extends BaseDto {
	private ClubDto club;

	private UserDto user;
	private RoleDto role;
	
	
	private Long id;
	private String status;
	private Timestamp createTime;
	private Timestamp updateTime;

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

	private static final long serialVersionUID = -4926938619167517315L;

	public UserClubRoleDto(BaseDto fromCopy) {
		copyPropertiesFrom(fromCopy);
	}

	public UserClubRoleDto() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ClubDto getClub() {
		return club;
	}

	public void setClub(ClubDto club) {
		this.club = club;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public RoleDto getRole() {
		return role;
	}

	public void setRole(RoleDto role) {
		this.role = role;
	}

}