package classwork.chapter5;

public class SwitchExample {
    public static void main(String[] args) {
        String lang = "arm";
//        if (lang.equals("ARM")) {
//            System.out.println("Բարև");
//        } else if (lang.equals("RU")) {
//            System.out.println("Привет");
//        } else if (lang.equals("ENG")) {
//            System.out.println("Hello");
//        } else {
//            System.out.println("language is not supported");
//        }

        switch (lang) {
            case "HY":
            case "hy":
            case "arm":
            case "ARM":
                System.out.println("Բարև");
                break;
            case "RU":
                System.out.println("Привет");
                break;
            case "ENG":
                System.out.println("Hello");
                break;
            default:
                System.out.println("language is not supported.");


        }
    }
}
