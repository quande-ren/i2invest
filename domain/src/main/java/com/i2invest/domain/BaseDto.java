package com.i2invest.domain;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

import lombok.Data;

@Data
public abstract class BaseDto  implements Serializable, Cloneable{
	private static final long serialVersionUID = 4324588586408069539L;

	private static final Logger logger=Logger.getLogger(BaseDto.class.getName());
	
	public BaseDto() {}
	
	public BaseDto(BaseDto fromCopy) {
		copyPropertiesFrom(fromCopy);
	}
	
	private static final Gson gson=new Gson();
	public String toJson() {
		return gson.toJson(this);
	}
	
	public DtoJsonWrapper toWrapper() {
		return new DtoJsonWrapper(this.getClass().getSimpleName(), toJson());
	}
	
	public void copyPropertiesFrom(BaseDto another)  {
		
		try {
			BeanUtils.copyProperties(this, another);
		} catch (IllegalAccessException | InvocationTargetException e) {
			logger.error("copy error", e);
			throw new RuntimeException(e.toString());
		}
	}
	
}
