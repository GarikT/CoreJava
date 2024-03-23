package classwork.chapter13;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        //String directoryPath = "/Users/garegintonoyan/Desktop/Taxes/Taxes23";
//        String directoryPath = "/Users/garegintonoyan/IdeaProjects/CoreJava/src/classwork/chapter13/test/notes1234.txt";
//        String fileName = "e.pdf";
//        String filePath = directoryPath + File.separator + fileName;
//        File file = new File(directoryPath);
//        boolean b = file.renameTo(new File(directoryPath));
//        System.out.println(b);
//        System.out.println(file.getName());
//        if(file.exists()){
//            System.out.println("Yes");
//        }
//        File file2 = new File(directoryPath);
//        if(file2.isDirectory()){
//            String[] list = file2.list();
//            for (String s : list) {
//                System.out.println(s);
//            }
//            System.out.println("=============");
//            File[] fileList = file2.listFiles();
//            for (File file1 : fileList) {
//                if(file1.isFile()) {
//                    System.out.println(file1.getName() + " -> " + file1.length());
//                    System.out.println(file1.getAbsoluteFile());
//                }else if(file1.isDirectory()){
//                    System.out.println("Directory!");
//                    System.out.println(file1.getParentFile());
//                }
//            }
//        }
//        System.out.println("Free space on my disc: "+file2.getFreeSpace());
        String newFilePath = "/Users/garegintonoyan/IdeaProjects/CoreJava/src/classwork/chapter13/test/test2/a/b/c";
        File file = new File(newFilePath);
        if(!file.exists()){
            boolean b = file.mkdirs();
            System.out.println(b);
        }
        boolean b = file.delete();
        System.out.println(b);
    }

}
