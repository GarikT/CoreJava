package classwork.chapter8.person;

public class DynamicDispatchTest {
    public static void main(String[] args) {
        Employee e = new Employee();
        sendEmail(e);

        Student student = new Student();
        sendEmail(student);


    }
//    public static void sendEmail(Employee e){
//        System.out.println("Sending email to " + e.getEmail());
//    }
//    public static void sendEmail(Student e){
//        System.out.println("Sending email to " + e.getEmail());
//    }
    public static void sendEmail(Person p){
        System.out.println("sending email to " + p.getEmail());
        p.printHello();
    }
}
