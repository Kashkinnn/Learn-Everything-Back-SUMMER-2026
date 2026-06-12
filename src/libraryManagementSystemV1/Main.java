package libraryManagementSystemV1;

import libraryManagementSystemV1.FileManagement.FileManagement;

import java.io.FileNotFoundException;

public class Main {

    void main() throws FileNotFoundException {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.addNewBook("test", "test", "Nov20");
        lms.addNewBook("test2", "test2", "Dec21");
        lms.addNewBook("test3", "test3", "Jan22");
        lms.removeBook(0);
        lms.displayAllBooks();

        lms.borrowBook(0, "Joel");
        System.out.println();
        lms.displayAllBorrowers();

        System.out.println();
        lms.displayAllBooks();

        lms.returnBook(0,"Joel");
        System.out.println();
        lms.displayAllBooks();
        System.out.println();
        lms.displayAllBorrowers();
        System.out.println(lms.bookCount());

        lms.addNewBook("test4", "test4", "feb1");

        System.out.println(lms.bookCount());
        lms.displayAllBooks();


        FileManagement fm = new FileManagement(lms.retrieveAllBooks());
        fm.createFile();
        fm.saveBooksToFile();

    }

}
