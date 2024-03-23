package homework.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin;
        try{
            fin = new FileInputStream("/Users/garegintonoyan/IdeaProjects/CoreJava/src/homework/chapter13/TEST.txt");
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("Cannot Open File");
            return;
        }
        try{
            do{
                i = fin.read();
                if(i != -1){
                    System.out.println((char) i);
                }
            }while(i != -1);
        }catch(IOException e){
            System.out.println("Error Reading File");
        }
        try{
            fin.close();
        }catch(IOException e){
            System.out.println("Error Closing File");
        }
    }
}
