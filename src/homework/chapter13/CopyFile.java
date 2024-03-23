package homework.chapter13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {
    public static void main(String[] args) {
        int i;
        FileInputStream fin = null;
        FileOutputStream fout = null;

        try{
            fin = new FileInputStream("/Users/garegintonoyan/IdeaProjects/CoreJava/src/homework/chapter13/TEST.txt");
            fout = new FileOutputStream("/Users/garegintonoyan/IdeaProjects/CoreJava/src/homework/chapter13/TEST2.txt");

            do{
                i = fin.read();
                if(i != -1){
                    fout.write(i);
                }
            }while(i != -1);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            try{
                if(fin != null){
                    fin.close();
                }
            }catch (IOException e2){
                System.out.println(e2.getMessage());
            }
            try{
                if(fout != null){
                    fout.close();
                }
            }catch (IOException e3){
                System.out.println(e3.getMessage());
            }
        }
    }
}
