package com.i2invest.domain.dto;

import com.i2invest.domain.BaseDto;

import lombok.Data;

@Data
public class FileDto extends BaseDto{
	private static final long serialVersionUID = -1921311143050905292L;

	private String id;

	  private String name;

	  private String type;

	  private byte[] data;

	  public FileDto() {
	  }

	  public FileDto(String name, String type, byte[] data) {
	    this.name = name;
	    this.type = type;
	    this.data = data;
	  }

	  public FileDto(String id, String name, String type) {
		    this.name = name;
		    this.type = type;
		    this.id = id;
		  }

	  public String getId() {
	    return id;
	  }

	  public String getName() {
	    return name;
	  }

	  public void setName(String name) {
	    this.name = name;
	  }

	  public String getType() {
	    return type;
	  }

	  public void setType(String type) {
	    this.type = type;
	  }

	  public byte[] getData() {
	    return data;
	  }

	  public void setData(byte[] data) {
	    this.data = data;
	  }

}
