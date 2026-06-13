package libraryManagementSystemV1.FileManagement;

import libraryManagementSystemV1.Book;
import libraryManagementSystemV1.LibraryManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FileManagement {
    List<Book> books;

    public FileManagement(List<Book> books){
        this.books = books;
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
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("lmsRecords.txt",false))){
            for(Book b : books){
                System.out.println(b.getId() + "|" + b.getName() + "|" + b.getAuthor() + "|" + b.getPubDate() + "|" + b.getStatus());
                bw.write(b.getId() + "|" + b.getName() + "|" + b.getAuthor() + "|" + b.getPubDate() + "|" + b.getStatus());
                bw.newLine();
            }
            System.out.println("File writing successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void loadBookIntoList(){

    }



}
