package ProjetoRestaurante.exception.business;
import ProjetoRestaurante.exception.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(String message) {
        super(ErrorCode.ENTITY_NOT_FOUND, message);
    }

    public NotFoundException(String message, Throwable cause){
        super(ErrorCode.ENTITY_NOT_FOUND, message, cause);
    }
}
