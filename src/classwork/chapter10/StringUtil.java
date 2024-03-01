package classwork.chapter10;

public class StringUtil {
    static String checkString(String s){
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                result = false;
                break;
            }
        }
        if(result){
            return s.toUpperCase();
        }
        throw new RuntimeException("String contains digit");

    }
}
