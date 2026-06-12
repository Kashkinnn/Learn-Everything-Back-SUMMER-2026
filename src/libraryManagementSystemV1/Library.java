package libraryManagementSystemV1;

public interface Library {
    void displayAllBooks();
    void displayAllBorrowers();
    void addNewBook(String name, String author, String pubDate);
    void removeBook(int id);
    void updateBook(int id);
    void borrowBook(int id, String borrower);
    void returnBook(int id, String borrower);
}
