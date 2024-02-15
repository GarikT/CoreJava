package classwork.Chapter7;

public class Example {
    public static void main(String[] args) {
        /* It's important to give language name in Program Arguments
        *  Edit Configuration / Program Arguments
        * */
        if(args.length >= 1){
            String language = args[0];
            switch (language){
                case "HY":
                    System.out.println("Բարև");
                    break;
                case "RU":
                    System.out.println("Привет");
                    break;
                case "ENG":
                    System.out.println("Hello");
                    break;
                default:
                    System.out.println("Language not supported");
            }
        }else{
            System.out.println("language not provided");
        }

    }
}
