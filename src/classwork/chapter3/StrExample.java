package classwork.chapter3;

public class StrExample {
    public static void main(String[] args) {
        char[] name = {'p', 'o', 'x', 'o', 's'};
        for (int i = 0; i < name.length; i++) {
            System.out.print(name[i]);
        }
        String nameStr = "Poxos";
        System.out.println(nameStr);
        char[] chars = nameStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.println(chars[i]);
        }
        for (int i = 0; i < nameStr.length(); i++) {
            System.out.println(nameStr.charAt(i));
        }
    }
}
