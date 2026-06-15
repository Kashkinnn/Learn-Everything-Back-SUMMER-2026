package libraryManagementSystemV1.FileManagement;

import libraryManagementSystemV1.Book;
import libraryManagementSystemV1.LibraryManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FileManagement {
    List<Book> books;

    public FileManagement(List<Book> books){
        this.books = books;
    }

    public List<List<Object>> readFile(String fileName){
        List<List<Object>> forReturn = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            String line;
            while((line = bufferedReader.readLine()) != null){
                String[] splitData = line.split("\\|");
                List<Object> innerList = new ArrayList<>(Arrays.asList(splitData));
                forReturn.add(innerList);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
//        System.out.println(forReturn);
        return forReturn;
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


}
