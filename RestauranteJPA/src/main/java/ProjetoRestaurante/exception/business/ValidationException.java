package ProjetoRestaurante.exception.business;
import ProjetoRestaurante.exception.ErrorCode;

public class ValidationException extends BusinessException {

    public ValidationException(String message) {
        super(ErrorCode.INVALID_INPUT, message);
    }

    public ValidationException(String message, Throwable cause){
        super(ErrorCode.INVALID_INPUT, message, cause);
    }
}
