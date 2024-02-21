package classwork.Chapter7.Library;

import java.util.Scanner;



public class LibraryMain {
    static Scanner s=new Scanner(System.in);
    static BookStorage bookStorage=new BookStorage();
    public static void main(String[] args) {


        boolean isRunning = true;
        while (isRunning) {
            printCommands();
            String command = s.nextLine();
            switch (command) {
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    addBook();
                    break;
                case "2":
                    searchBook();
                    break;
                case "3":
                    bookStorage.print();
                    break;
                default:
                    System.out.println("Invalid command. try again!");

            }
        }

    }

    private static void searchBook() {
        System.out.println("Please enter keyword:");
        String keyword = s.nextLine();
        bookStorage.search(keyword);
    }

    private static void addBook() {
        System.out.println("Please enter book title");
        String title = s.nextLine();
        System.out.println("Please enter author name");
        String authorName = s.nextLine();
        System.out.println("Please enter price");
        double price = Double.parseDouble(s.nextLine());
        System.out.println("Please enter count");
        int count = Integer.parseInt(s.nextLine());
        Book book = new Book(title, authorName, price, count);
        System.out.println("Book created!");
        bookStorage.add(book);
    }

    private static void printCommands() {
        System.out.println("Please input 0 for EXIT");
        System.out.println("Please input 1 to ADD BOOK");
        System.out.println("Please input 2 to SEARCH BOOK");
        System.out.println("Please input 3 to PRINT ALL BOOKS");
    }
}
