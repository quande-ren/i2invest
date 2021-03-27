
package com.i2invest.domain;
import com.i2invest.domain.appexception.AppException;
import com.i2invest.domain.request.BaseRequest;
import com.i2invest.domain.response.BaseResponse;

public interface FacadeService {

	public void sayHelloFromServiceBean() ;

	public BaseResponse processRequest(BaseRequest requ) throws AppException;

}
