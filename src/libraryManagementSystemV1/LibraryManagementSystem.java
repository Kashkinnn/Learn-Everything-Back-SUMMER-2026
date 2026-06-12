package libraryManagementSystemV1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class LibraryManagementSystem implements Library{
    private ArrayList<Book> books;
    private HashMap<String, Book> borrowers;
    private int id;

    public LibraryManagementSystem(){
        books = new ArrayList<>();
        borrowers = new HashMap<>();
        id = 1;
    }

    @Override
    public void displayAllBooks() {
        for(Book b : books){
            System.out.println(b + " is borrowed: " + b.getStatus());
        }
    }

    @Override
    public void displayAllBorrowers(){
        for(String i : borrowers.keySet()){
            System.out.println("Borrower: " + i + " Book " + borrowers.get(i));
        }
    }

    @Override
    public void addNewBook(String name, String author, String pubDate) {
        Book b = new Book(name, author, pubDate, id++);
        books.add(b);
        System.out.println("Successfully added: " + b);
    }

    @Override
    public void removeBook(int id) {
        Book book = findBookById(id);

        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        books.remove(book);
        System.out.println("Book successfully removed!");
    }

    @Override
    public void updateBook(int id) {
        Book book = findBookById(id);
        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Input Book Name - Author - PubDate");
        String newName = sc.nextLine();
        String newAuthor = sc.nextLine();
        String newPubDate = sc.nextLine();

        book.setName(newName);
        book.setAuthor(newAuthor);
        book.setPubDate(newPubDate);

        System.out.println("Successfully updated book" + book);

    }

    @Override
    public void borrowBook(int id, String borrower) {
        Book book = findBookById(id);

        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        if(book.borrowBook()){
            borrowers.put(borrower, book);
            System.out.println("Successfully borrowed " + book + " by " + borrower);
            return;
        }

        System.out.println("No books borrowed");
    }

    @Override
    public void returnBook(int id, String borrower) {
        Book book = findBookById(id);

        if(book == null){
            System.out.println("Book not found!");
            return;
        }

        if(book.returnBook()){
            borrowers.remove(borrower, book);
            System.out.println("Successfully returned " + book + " by " + borrower);
            return;
        }

        System.out.println("No book returned");
    }

    private Book findBookById(int id){
        for(Book b : books){
            if(b.getId() == id){
                return b;
            }
        }

        return null;
    }

    public int bookCount(){
        return books.size();
    }

    public ArrayList<Book> retrieveAllBooks(){
        return books;
    }


}
