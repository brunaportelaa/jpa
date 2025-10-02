package ProjetoRestaurante.exception.dao;

import ProjetoRestaurante.exception.ErrorCode;

public class DataIntegrityException extends DataAccessException {
    public DataIntegrityException(String message) {
        super(ErrorCode.DATA_INTEGRITY_VIOLATION, message);
    }

    public DataIntegrityException(String message, Throwable cause) {
        super(ErrorCode.DATA_INTEGRITY_VIOLATION, message, cause);
    }
}
