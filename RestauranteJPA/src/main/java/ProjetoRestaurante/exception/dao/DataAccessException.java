package ProjetoRestaurante.exception.dao;

import ProjetoRestaurante.exception.ApplicationException;
import ProjetoRestaurante.exception.ErrorCode;

public class DataAccessException extends ApplicationException {
    public DataAccessException(String message) {
        super(ErrorCode.DATABASE_ERROR, message);
    }

    public DataAccessException(ErrorCode code, String message) {
        super(code, message);
    }

    public DataAccessException(ErrorCode code, String message, Throwable cause) {
        super(code, message, cause);
    }

    public DataAccessException(String message, Throwable cause) {
        super(ErrorCode.DATABASE_ERROR, message, cause);
    }
}
