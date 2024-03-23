package homework.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileWithTryResources {
    public static void main(String[] args) {
        int i;
        try(FileInputStream fin = new FileInputStream("/Users/garegintonoyan/IdeaProjects/CoreJava/src/homework/chapter13/TEST.txt");
            FileOutputStream fout = new FileOutputStream("/Users/garegintonoyan/IdeaProjects/CoreJava/src/homework/chapter13/TEST2.txt")){
            do{
                i = fin.read();
                if(i != -1){
                    fout.write(i);
                }
            }while (i != -1);
        }catch (IOException e){
            System.out.println("I/O Error: " + e);
        }
    }
}
