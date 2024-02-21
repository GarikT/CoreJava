package homework.employee;

import java.util.Scanner;

public class EmployeeStorage {
    private Employee[] employeeStorage = new Employee[10];
    private int size;

    public void add(Employee e) {
        if(employeeStorage.length == size){
            extend();
        }
        employeeStorage[size++] = e;
    }

    public void extend() {
        Employee[] temp = new Employee[size + 10];
        System.arraycopy(employeeStorage, 0, temp, 0, employeeStorage.length);
        employeeStorage = temp;

    }

    public void print() {
        Employee e;
        for (int i = 0; i < size; i++) {
            e = employeeStorage[i];
            System.out.println(e.getEmployeeID() + ": " + e.getName() + " " + e.getSurname() +
                    " works for " + e.getCompany() + " as " + e.getPosition() +
                    " and receives $" + e.getSalary() + " salary");
        }
    }

    public Employee search(String id) {
        Employee e;
        for (int i = 0; i < size; i++) {
            e = employeeStorage[i];
            if(e.getEmployeeID().contains(id)){
                return e;
            }
        }
        return null;
    }
    public void searchByCompany(String company){
        Employee e;
        for (int i = 0; i < size; i++) {
            e = employeeStorage[i];
            if(e.getCompany().contains(company)){
                System.out.println(e.getEmployeeID() + ": " + e.getName() + " " + e.getSurname() +
                        " works for " + e.getCompany() + " as " + e.getPosition() +
                        " and receives $" + e.getSalary() + " salary");
            }
        }
    }
    public void deleteByID(String id){
        if(size <= 0){
            System.out.println("No employees in storage");
            return;
        }
        int i = findByID(id);
        if(i == -1){
            System.out.println("No employees found with this ID");
        }else{
            shift(i);
            System.out.println("Employee successfully removed");
        }
    }
    private void shift(int i){
        if(i < size) {
            for (int j = i + 1; j < size; j++) {
                employeeStorage[j - 1] = employeeStorage[j];
            }
            employeeStorage[--size] = null;
        }

    }
    public int findByID(String id){
        int result = -1;
        for (int i = 0; i < size; i++) {
            if(employeeStorage[i].getEmployeeID().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }

    public void changeByID(int i){
        if(i == -1){
            System.out.println("No such ID");
        }
        Scanner s = new Scanner(System.in);
        System.out.println("What's the new ID for this employee?");
        employeeStorage[i].setEmployeeID(s.nextLine());
        System.out.println("What's the new name for this employee?");
        employeeStorage[i].setName(s.nextLine());
        System.out.println("What's the new surname for this employee?");
        employeeStorage[i].setSurname(s.nextLine());
        System.out.println("What's the new company name for this employee?");
        employeeStorage[i].setCompany(s.nextLine());
        System.out.println("What's the new position for this employee?");
        employeeStorage[i].setPosition(s.nextLine());
        System.out.println("What's the new salary of this employee?");
        employeeStorage[i].setSalary(Double.parseDouble(s.nextLine()));
        System.out.println("Everything updated. Thank you!");
    }

}
