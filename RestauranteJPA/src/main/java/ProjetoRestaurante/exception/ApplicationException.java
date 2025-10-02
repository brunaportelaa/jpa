package ProjetoRestaurante.exception;

public class ApplicationException extends RuntimeException {

    private final ErrorCode errorCode;

    public ApplicationException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ApplicationException(ErrorCode errCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
