package homework.chapter13;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ShowFileWithTryResources {
    public static void main(String[] args) {
        int i;
        try(FileInputStream fin = new FileInputStream("/Users/garegintonoyan/IdeaProjects/CoreJava/src/homework/chapter13/TEST.txt")){
            do{
                i = fin.read();
                if(i != -1){
                    System.out.println((char)i);
                }
            }while (i != -1);
        }catch (FileNotFoundException e){
            System.out.println("file Not Found");
        }catch (IOException e){
            System.out.println("An I/O Error Occurred");
        }
    }
}
