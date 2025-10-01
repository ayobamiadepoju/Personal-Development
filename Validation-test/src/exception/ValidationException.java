package exception;

public class ValidationException extends Exception {
    public ValidationException(String fieldName, String message) {
        super("Validation failed for field '" + fieldName + "': " + message);
    }
}
