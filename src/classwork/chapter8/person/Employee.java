package classwork.chapter8.person;

public class Employee extends Person{
    private String employeeId;
    private double salary;
    private String position;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(String name, String surname, String email, String phone, String employeeId, double salary, String position) {
        super(name, surname, email, phone);
        this.employeeId = employeeId;
        this.salary = salary;
        this.position = position;
    }

    public Employee() {
    }

    public void printHello(){
        System.out.println("Привет !!!");
    }
}
