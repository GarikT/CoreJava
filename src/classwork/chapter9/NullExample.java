package classwork.chapter9;

import java.util.Date;

public class NullExample {
    public static void main(String[] args) {
        Date date = null;
//        System.out.println(date.getTime());
        date = getToday(true);
        System.out.println(date.getTime());

    }

    static Date getToday(boolean a){
        if(a){
            return new Date();
        }
        return null;
    }
}
