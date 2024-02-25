package classwork.chapter9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateExample {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        System.out.println(sdf.format(date));

        System.out.println("please enter birthday(dd/MM/yyyy)");
        String birthdayStr = scanner.nextLine();
        Date bd = sdf.parse(birthdayStr);
        System.out.println(sdf.format(bd));
    }
}
