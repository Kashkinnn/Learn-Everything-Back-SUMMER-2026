package libraryManagementSystemV1;

import libraryManagementSystemV1.CustomExceptions.*;

import java.util.*;

public class LibraryManagementSystem implements Library{
    private ArrayList<Book> books;
    private HashMap<String, ArrayList<Book>> borrowers;
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
            throw new BookNotFoundException("Book Not found");
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
            throw new BookNotFoundException("Book Not found");
        }

        if(book.getStatus()){
            throw new BookAlreadyBorrowedException("Book not here bru!");
        }

        if(book.borrowBook()){
            if(!borrowers.containsKey(borrower)){
                borrowers.put(borrower, new ArrayList<Book>());
            }

            borrowers.get(borrower).add(book);

            System.out.println("Successfully borrowed " + book + " by " + borrower);
            return;
        }

        System.out.println("No books borrowed");
    }

    @Override
    public void returnBook(int id, String borrower) {
        if(!borrowers.containsKey(borrower)){
            throw new BorrowerNotFound("No borrower");
        }

        Book book = findBookById(id);

        if(borrowers.get(borrower).contains(book)){
            throw new WrongBorrowerException(borrower + "is not the borrower");
        }

        if(book == null){
            throw new BookNotFoundException("Book Not found");
        }

        if(book.getStatus() == false){
            throw new BookNotBorrowedException("Book is still here bru");
        }

        if(book.returnBook()){
            borrowers.get(borrower).remove(book);
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

    public List<Book> retrieveAllBooks(){
        List<Book> unmodifiable = Collections.unmodifiableList(books);
        return unmodifiable;
    }

    public void loadBooksFromFile(List<List<Object>> curr) {
        for(List<Object> inner : curr){
            System.out.println(inner);
            addNewBookFromFile(inner);
        }
    }


    public void addNewBookFromFile(List<Object> b) {
        try {
            String idString = (String) b.get(0);
            int bookId = Integer.parseInt(idString.trim());
            String booleanString = (String) b.get(4);
            boolean status = Boolean.parseBoolean(booleanString);
            Book bAdd = new Book((String) b.get(1), (String) b.get(2), (String) b.get(3), bookId, status);
            books.add(bAdd);
            System.out.println("Successfully added: " + b);

        } catch (ClassCastException e) {
            System.out.println("Casting error - ensure your list only contains strings.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Parsing error - tried to turn a non-number into an int: " + b.get(0));
            e.printStackTrace();
        }
    }


}
