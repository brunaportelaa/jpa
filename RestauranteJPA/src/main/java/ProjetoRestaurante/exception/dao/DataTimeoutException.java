package ProjetoRestaurante.exception.dao;

import ProjetoRestaurante.exception.ErrorCode;

public class DataTimeoutException extends DataAccessException {
    public DataTimeoutException(String message) {
        super(ErrorCode.DATA_TIMEOUT, message);
    }

    public DataTimeoutException(String message, Throwable cause) {
        super(ErrorCode.DATA_TIMEOUT, message, cause);
    }
}
