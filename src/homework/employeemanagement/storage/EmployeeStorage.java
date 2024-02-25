package homework.employeemanagement.storage;

import homework.employeemanagement.model.Company;
import homework.employeemanagement.model.Employee;

public class EmployeeStorage {
    private Employee[] employees = new Employee[10];
    private int size;
    public void add(Employee employee){
        if(size == employees.length){
            extend();
        }
        employees[size++] = employee;
    }
    public void print(){
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    private void extend() {
        Employee[] temp = new Employee[employees.length + 10];
        System.arraycopy(employees, 0, temp, 0, employees.length);
        employees = temp;
    }

    public Employee getById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if(employees[i].getId().equals(employeeId)){
                return employees[i];
            }
        }
        return null;
    }

    public void searchEmployeeByCompany(Company employeFromStorage) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getCompany().equals((employeFromStorage))){
                System.out.println(employees[i]);
            }
        }
    }
    public void deleteById(String employeId) {
        int indexById = getIndexById(employeId);
        if(indexById == -1){
            System.out.println("Employee does not exist");
            return;
        }
        for (int i = indexById + 1; i < size; i++) {
            employees[i-1] = employees[i];
        }
        size--;
    }
    private int getIndexById(String employeId){
        for (int i = 0; i < size; i++) {
            if(employees[i].getId().equals(employeId)){
                return i;
            }
        }
        return -1;
    }
}
