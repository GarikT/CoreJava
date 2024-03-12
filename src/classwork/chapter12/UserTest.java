package classwork.chapter12;

public class UserTest {
    public static void main(String[] args) {
        User user = new User("Poxos", "Poxosyan", "poxosyan@mail.com", Language.HY);
        User user1 = new User("Petros", "Petrosyan", "petrosyan@mail.com", Language.RU);
        System.out.println(user);
        System.out.println(user1);
        String lang = Language.HY.name();
        System.out.println(lang);

        Language[] values = Language.values();
        for (Language value : values) {
            System.out.println(value + " " + value.getLanguageName() + " " + value.ordinal());
        }
    }
}
