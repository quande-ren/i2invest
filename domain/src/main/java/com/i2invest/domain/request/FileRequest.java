package com.i2invest.domain.request;

import com.i2invest.domain.dto.FileDto;
import com.i2invest.domain.response.FileResponse;

import lombok.Data;

@Data
public  class FileRequest extends BaseRequest<FileResponse>{
	private static final long serialVersionUID = 6556666213116651308L;
	public FileDto file;
	public String requestType;
	
	public static final String RequestType_RetrieveWithData="RetrieveWithData";
	public static final String RequestType_RetrieveWithoutData="RetrieveWithoutData";

	public FileRequest() {
	}
	public FileRequest(String requestType) {
		this.requestType=requestType;
	}

	public FileRequest(String requestType, FileDto file ) {
		this.requestType=requestType;
		this.file=file;
	}

	public  FileResponse getDummayResponse() {
		return new FileResponse();
	}

}
