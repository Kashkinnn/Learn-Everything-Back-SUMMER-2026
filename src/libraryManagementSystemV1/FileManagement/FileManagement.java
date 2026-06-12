package libraryManagementSystemV1.FileManagement;

import libraryManagementSystemV1.Book;
import libraryManagementSystemV1.LibraryManagementSystem;

import java.io.*;
import java.util.ArrayList;

public class FileManagement {
    LibraryManagementSystem lms;
    ArrayList<Book> books;

    public FileManagement(ArrayList<Book> books){
        lms = new LibraryManagementSystem();
        this.books = books;
    }

    public void createFile(){
        File Obj = new File("lmsRecords.txt");
    }

    public void readFile(){
        try{
            File file = new File("lmsRecords.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void saveBooksToFile(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("lmsRecords.txt", true))){
            for(Book b : books){
                System.out.println("Writing " + b);
                bw.write(b.toString());
                bw.newLine();
            }
            System.out.println("File writing successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    void main(){
        for(Book b : books){
            System.out.println(b);
        }
    }

}
