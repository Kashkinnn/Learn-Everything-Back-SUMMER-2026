package libraryManagementSystemV1.CustomExceptions;

public class BookNotBorrowedException extends RuntimeException {
    public BookNotBorrowedException(String message) {
        super(message);
    }
}
