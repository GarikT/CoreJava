package classwork.immutable;

import java.util.ArrayList;
import java.util.List;

public class UserDemo {

    public static void main(String[] args)  {
        List<String> lang = new ArrayList<>();
        lang.add("Arm");
        lang.add("Ru");
        User user = new User("Poxos", "Poxosyan", "Poxos@mail.com", "1234", lang);
        System.out.println(user);
        System.out.println(user.hashCode());
        user.getLanguageList().add("Eng");
        System.out.println(user);
        System.out.println(user.hashCode());
    }
}
