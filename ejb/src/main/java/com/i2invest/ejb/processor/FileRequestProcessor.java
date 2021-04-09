package com.i2invest.ejb.processor;

import java.util.List;

import javax.persistence.EntityManager;

import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.appexception.MissingParameterException;
import com.i2invest.domain.dto.FileDto;
import com.i2invest.domain.request.FileRequest;
import com.i2invest.domain.response.FileResponse;
import com.i2invest.ejb.AbstractRequestProcessor;
import com.i2invest.ejb.entity.FileEjb;
import com.i2invest.ejb.entity.UserEjb;

public class FileRequestProcessor extends AbstractRequestProcessor<FileRequest, FileResponse> {
	public void process(EntityManager entityManager, FileRequest request, FileResponse response, UserEjb currentUserEjb) throws AppException{
		if(FileRequest.RequestType_Create.equals(request.requestType)) {
			FileEjb ejb=new FileEjb(request.file);
			entityManager.persist(ejb);
			response.file=new FileDto(ejb.getId(), ejb.getName(), ejb.getType());
		}else if(FileRequest.RequestType_RetrieveWithoutData.equals(request.requestType)) {
			List<FileEjb> fileEjbs=entityManager.createQuery("from FileEjb p", FileEjb.class).getResultList();
			if(fileEjbs!=null) {
				FileDto[] result = new FileDto[fileEjbs.size()];
				int i=0;
				for(FileEjb ejb: fileEjbs) {
					result[i]=new FileDto(ejb.getId(), ejb.getName(), ejb.getType());
					i++;
				}
				
				response.files=result;
			}
		}
	}

	public void verifyData(FileRequest request) throws MissingParameterException {
	}
	
}
