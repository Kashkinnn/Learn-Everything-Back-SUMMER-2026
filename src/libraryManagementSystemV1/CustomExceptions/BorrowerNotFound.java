package libraryManagementSystemV1.CustomExceptions;

public class BorrowerNotFound extends RuntimeException {
    public BorrowerNotFound(String message) {
        super(message);
    }
}
