package com.i2invest.domain.response;

import com.i2invest.domain.dto.FileDto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public  class FileResponse extends BaseResponse {
	private static final long serialVersionUID = -151115347725319372L;
	public FileDto file;
	public FileDto[] files;
	public FileResponse() {
	}

	public FileResponse(FileDto file) {
		this.file=file;
	}

	public FileResponse(FileDto[] files) {
		this.files=files;
	}

	
}
