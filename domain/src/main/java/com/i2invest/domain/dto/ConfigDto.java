package com.i2invest.domain.dto;

import java.util.Date;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public  class ConfigDto extends BaseDto{
	private   Long id;
	private   String tableName;
	private   String fieldName;
	private   String fieldValue;
	private   String configValue;
	private   String description;
	private   String status;
	private   Date createTime;
	private   Date updateTime;

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ConfigDto(BaseDto fromCopy) {
		super(fromCopy);
	}

	public ConfigDto() {}

}