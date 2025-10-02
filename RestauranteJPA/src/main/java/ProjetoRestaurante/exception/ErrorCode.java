package ProjetoRestaurante.exception;

public enum ErrorCode {
    // Business / Validation
    INVALID_INPUT("Invalid input"),
    ENTITY_NOT_FOUND("Entity not found"),
    CONFLICT("Conflict"),

    // Data access
    DATABASE_ERROR("Database error"),
    DATA_INTEGRITY_VIOLATION("Data integrity violation"),
    DATA_TIMEOUT("Data access timeout"),

    // Service / Unexpected
    BUSINESS_ERROR("Business error"),
    UNEXPECTED("Unexpected error");

    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
