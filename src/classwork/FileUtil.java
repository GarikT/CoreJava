package classwork;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static boolean fileSearch(String path, String fileName){
        File file = new File(path, fileName);
        return file.exists();
    }

    public static void contentSearch(String path, String keyword){
        File directory = new File(path);
        if(directory.isDirectory()){
            File[] files = directory.listFiles();
            for (File file : files) {
                if(file.isFile() && file.getName().endsWith(".txt")){
                    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                        String line = null;
                        int lineNumber = 1;
                        while( (line = bufferedReader.readLine()) != null ){
                            if (line.contains(keyword)) {
                                System.out.println(ANSI_GREEN + file.getName() + " " + ANSI_YELLOW + " line number: " + lineNumber + ANSI_PURPLE +  " line: " + line + ANSI_RESET);
                                break;
                            }
                        }
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }else if(file.isDirectory()){
                    contentSearch(file.getAbsolutePath(), keyword);
                }
            }
        }
    }

}
