package libraryManagementSystemV1.FileManagement;

import libraryManagementSystemV1.Book;
import libraryManagementSystemV1.LibraryManagementSystem;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class FileManagement {
    List<Book> books;

    public FileManagement(List<Book> books){
        this.books = books;
    }

    public List<List<String>> readFile(String fileName){
        List<List<String>> forReturn = new ArrayList<>();
        try{
            File file = new File(fileName);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            List<String> innerList = new ArrayList<>();
            while((line = bufferedReader.readLine()) != null){
                innerList.clear();
                line = Arrays.toString(line.split("\\|"));
                innerList.add(line);
                System.out.println(innerList);
                forReturn.add(innerList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

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
