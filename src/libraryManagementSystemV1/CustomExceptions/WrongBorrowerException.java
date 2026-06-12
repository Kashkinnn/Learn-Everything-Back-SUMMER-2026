package libraryManagementSystemV1.CustomExceptions;

public class WrongBorrowerException extends RuntimeException {
    public WrongBorrowerException(String message) {
        super(message);
    }
}
