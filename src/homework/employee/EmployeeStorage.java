package homework.employee;

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
}
