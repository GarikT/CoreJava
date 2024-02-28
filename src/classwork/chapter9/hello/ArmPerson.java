package classwork.chapter9.hello;

public class ArmPerson implements SayHello, SayGoodBye{
    @Override
    public String sayHello() {
        return "Բարև";
    }

    @Override
    public String sayGoodBye() {
        return "ցտեսություն";
    }
}
