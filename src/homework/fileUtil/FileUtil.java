package homework.fileUtil;

import java.io.*;
import java.util.Scanner;

public class FileUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //createFileWithContent();
        //printSizeOfPackage();
        //findLines();
        //contentSearch();
        fileSearch();
    }
    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static void fileSearch() {
        System.out.println("Please enter folder path");
        String path = scanner.nextLine();
        System.out.println("Please enter file name:");
        String fileName = scanner.nextLine();
        File file = new File(path);
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].getName().equals(fileName)) {
                    System.out.println("True");
                    return;
                }
            }
            System.out.println("False");
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    static void contentSearch() {
        System.out.println("Please enter folder path:");
        String path = scanner.nextLine();
        System.out.println("Please enter keyword:");
        String keyword = scanner.nextLine();
        File file = new File(path);
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if(files[i].getName().contains(".txt")){
                    try(BufferedReader bufferedReader = new BufferedReader(new FileReader(files[i].getAbsolutePath()))) {
                        String temp = bufferedReader.readLine();
                        while (temp != null) {
                            if (temp.contains(keyword)) {
                                System.out.println(files[i].getName());
                                temp = null;
                            } else {
                                temp = bufferedReader.readLine();
                            }

                        }
                    }catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - txtPath txt ֆայլի փաթը
    // 2 - keyword - ինչ որ բառ
    // տալու ենք txt ֆայլի տեղը, ու ինչ որ բառ, ինքը տպելու է էն տողերը, որտեղ գտնի էդ բառը։
    static void findLines() {
        System.out.println("Please enter path of a file:");
        String path = scanner.nextLine();
        System.out.println("Please enter a keyword");
        String keyword = scanner.nextLine();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String temp = bufferedReader.readLine();
            while(temp != null) {
                if(temp.contains(keyword)){
                    System.out.println(temp);
                }
                temp = bufferedReader.readLine();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static void printSizeOfPackage() {
        System.out.println("Please enter the path of a folder:");
        String path = scanner.nextLine();
        File file = new File(path);
        long size = 0;
        if(file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0; i <files.length; i++) {
                size += files[i].length();
            }
            System.out.println("This folder is total of " + size + " bytes!");
        }
    }

    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("Please enter folder path: ");
        String path = scanner.nextLine();
        System.out.println("Please enter new file name: ");
        String fileName = scanner.nextLine();
        System.out.println("Please enter text that goes into the file: ");
        String content = scanner.nextLine();
        String newFilePath = path + File.separator + fileName;
        try(FileWriter fileWriter = new FileWriter(newFilePath)){
            fileWriter.write(content);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }

}
