package libraryManagementSystemV1;

public class Book{
    private String name;
    private String author;
    private String pubDate;
    private int id;
    private boolean isBorrowed;

    public Book(){
        name = null;
        author = null;
        pubDate = null;
        id = 0;
    }

    public Book(String name, String author, String pubDate, int id){
        this.name = name;
        this.author = author;
        this.pubDate = pubDate;
        this.id = id;
        this.isBorrowed = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public int getId(){
        return id;
    }

    public boolean getStatus(){
        return isBorrowed;
    }

    public boolean borrowBook(){
        if(isBorrowed){
            System.out.println("Book is currently being borrowed");
            return false;
        }
        isBorrowed = true;
        return true;
    }

    public boolean returnBook(){
        if(!isBorrowed){
            System.out.println("Book is currently in the library");
            return false;
        }
        isBorrowed = false;
        return true;
    }

    @Override
    public String toString(){
        return this.name + " + " + this.author + " + " + getPubDate() + " + " +  id;
    }
};
