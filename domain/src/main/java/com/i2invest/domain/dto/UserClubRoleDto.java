package com.i2invest.domain.dto;

import java.sql.Timestamp;

import com.i2invest.domain.BaseDto;

import lombok.Data;


@Data
public  class UserClubRoleDto extends BaseDto{
	private static final long serialVersionUID = -4926938619167517315L;

	public UserClubRoleDto(BaseDto fromCopy) {
		copyPropertiesFrom(fromCopy);
	}


	public UserClubRoleDto() {}
	
	private   Long id;
	private   Long userId;
	private   Long clubId;
	private   Long roleId;
	private   String status;
	private   Timestamp createTime;
	private   Timestamp updateTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}