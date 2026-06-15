package libraryManagementSystemV1;

import libraryManagementSystemV1.FileManagement.FileManagement;

import java.io.FileNotFoundException;

public class Main {

    void main() throws Exception {
        LibraryManagementSystem lms = new LibraryManagementSystem();
//        lms.addNewBook("test", "test", "Nov20");
//        lms.addNewBook("test2", "test2", "Dec21");
//        lms.addNewBook("test3", "test3", "Jan22");
//        lms.addNewBook("test4", "test4", "feb1");
//
        FileManagement fm = new FileManagement(lms.retrieveAllBooks());
//        fm.saveBooksToFile();
//
//        lms.addNewBook("Test5", "Test5", "Mar20");
//
//        fm.saveBooksToFile();

//        lms.borrowBook(2, "Joel");
//        System.out.println();
//        lms.displayAllBorrowers();

//        System.out.println();
//        fm.readFile("lmsRecords.txt");
        System.out.println(fm.readFile("lmsRecords.txt"));
//        System.out.println();
        lms.loadBooksFromFile(fm.readFile("lmsRecords.txt"));
        System.out.println();
        lms.displayAllBooks();

    }

}
