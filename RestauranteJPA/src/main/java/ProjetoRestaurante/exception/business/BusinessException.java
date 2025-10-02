package ProjetoRestaurante.exception.business;

import ProjetoRestaurante.exception.ApplicationException;
import ProjetoRestaurante.exception.ErrorCode;

public class BusinessException extends ApplicationException {

  public BusinessException(String message){
    super(ErrorCode.BUSINESS_ERROR, message);
  }

  public BusinessException(String message, Throwable cause) {
    super(ErrorCode.BUSINESS_ERROR, message, cause);
  }

  public BusinessException(ErrorCode code, String message, Throwable cause) {
    super(code, message, cause);
  }

  public BusinessException(ErrorCode code, String message) {
    super(code, message);
  }
}
