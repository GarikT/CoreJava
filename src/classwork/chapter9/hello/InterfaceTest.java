package classwork.chapter9.hello;

public class InterfaceTest {
    public static void main(String[] args) {
        ArmPerson armPerson = new ArmPerson();
        RussianPerson russianPerson = new RussianPerson();
        EnglishPerson englishPerson = new EnglishPerson();
        printHello(englishPerson);
        printHello(russianPerson);
        printHello(armPerson);

    }
//    static void printHello(ArmPerson armPerson){
//        System.out.println(armPerson.sayHello());
//    }
    static void printHello(SayHello sayHello){
        System.out.println(sayHello.sayHello());
        if(sayHello instanceof SayGoodBye){
            SayGoodBye sayGoodBye = (SayGoodBye) sayHello;
            System.out.println(sayGoodBye.sayGoodBye());
        }
    }
}
