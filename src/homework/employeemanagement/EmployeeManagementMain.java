package homework.employeemanagement;

import java.util.Scanner;

public class EmployeeManagementMain {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();
    public static void main(String[] args) {
        boolean isRunning = true;
        while(isRunning){
            printCommands();
            String command = scanner.nextLine();
            switch (command){
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    addCompany();
                    break;
                case "2":
                    addEmployee();
                    break;
                case"3":
                    companyStorage.print();
                    break;
                case "4":
                    employeeStorage.print();
                    break;
                case "5":
                    searchEmployeeById();
                    break;
                case "6":
                    searchEmployeeByCompany();
                    break;
                case "7":
                    deleteCopany();
                    break;
                case "8":
                    deleteEmployee();
                    break;
                case "9":
                    changeCompany();
                    break;
                case "10":
                    changeEmployee();
                    break;
                default:
                    System.out.println("Invalid command, try again!");

            }
        }
    }

    private static void changeEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null){
            System.out.println("Company with " + companyId + " does not exists.");
            return;
        }
        employeeStorage.searchEmployeeByCompany(companyFromStorage);

        System.out.println("Please enter employee ID");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if(employeeFromStorage == null){
            System.out.println("Employee with " + employeeId + " does not exists");
            return;
        }
        System.out.println("Please enter employee name");
        String employeeName = scanner.nextLine();
        System.out.println("Please enter employee surname");
        String employeeSurname = scanner.nextLine();
        System.out.println("Please enter employee phone number");
        String employeePhoneNumber = scanner.nextLine();
        System.out.println("Please enter employee position");
        String employeePosition = scanner.nextLine();
        System.out.println("Please enter employee salary in AMD");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        employeeFromStorage.setName(employeeName);
        employeeFromStorage.setSurname(employeeSurname);
        employeeFromStorage.setPhone(employeePhoneNumber);
        employeeFromStorage.setPosition(employeePosition);
        employeeFromStorage.setSalary(employeeSalary);
        System.out.println("Employee updated");
    }

    private static void changeCompany() {
        System.out.println("Please enter company ID");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null){
            System.out.println("Company with " + companyId + " does not exists.");
            return;
        }
        System.out.println("Please enter company new name");
        String companyName = scanner.nextLine();
        System.out.println("Please enter company new address");
        String companyAddress = scanner.nextLine();
        companyFromStorage.setName(companyName);
        companyFromStorage.setAddress(companyAddress);
        System.out.println("Company updated");
    }

    private static void deleteEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null){
            System.out.println("Company with " + companyId + " does not exists.");
            return;
        }
        employeeStorage.searchEmployeeByCompany(companyFromStorage);
        System.out.println("Please enter employee ID");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if(employeeFromStorage == null){
            System.out.println("Employee with " + employeeId + " does not exists");
            return;
        }
        if(!employeeFromStorage.getCompany().equals(companyFromStorage)){
            System.out.println("Wrong employee id.");
            return;
        }
        employeeStorage.deleteById(employeeId);

    }

    private static void deleteCopany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null){
            System.out.println("Company with " + companyId + " does not exists.");
            return;
        }
        companyStorage.deleteById(companyId);
    }

    private static void searchEmployeeByCompany() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null){
            System.out.println("Company with " + companyId + " does not exists.");
            return;
        }
        employeeStorage.searchEmployeeByCompany(companyFromStorage);
    }

    private static void searchEmployeeById() {
        System.out.println("Please enter employee ID");
        String employeeId = scanner.nextLine();
        Employee byId = employeeStorage.getById(employeeId);
        if(byId == null){
            System.out.println("Employee does not exist");
        }else{
            System.out.println(byId);
        }
    }

    private static void addEmployee() {
        System.out.println("Please choose company id");
        companyStorage.print();
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage == null){
            System.out.println("Company with " + companyId + " does not exists.");
            return;
        }
        System.out.println("Please enter employee ID");
        String employeeId = scanner.nextLine();
        Employee employeeFromStorage = employeeStorage.getById(employeeId);
        if(employeeFromStorage != null){
            System.out.println("Employee with " + employeeId + " already exists");
            return;
        }
        System.out.println("Please enter employee name");
        String employeeName = scanner.nextLine();
        System.out.println("Please enter employee surname");
        String employeeSurname = scanner.nextLine();
        System.out.println("Please enter employee phone number");
        String employeePhoneNumber = scanner.nextLine();
        System.out.println("Please enter employee position");
        String employeePosition = scanner.nextLine();
        System.out.println("Please enter employee salary in AMD");
        double employeeSalary = Double.parseDouble(scanner.nextLine());
        Employee employee = new Employee(employeeId, employeeName, employeeSurname, employeePhoneNumber, employeeSalary, employeePosition, companyFromStorage);
        employeeStorage.add(employee);
        System.out.println("Employee Registered");
    }

    private static void addCompany() {
        System.out.println("Please enter company ID");
        String companyId = scanner.nextLine();
        Company companyFromStorage = companyStorage.getById(companyId);
        if(companyFromStorage != null){
            System.out.println("Company with " + companyId + " already exists.");
            return;
        }
        System.out.println("Please enter company name");
        String companyName = scanner.nextLine();
        System.out.println("Please enter company address");
        String companyAddress = scanner.nextLine();
        Company compnay = new Company(companyId, companyName, companyAddress);
        companyStorage.add(compnay);
        System.out.println("Company registered");
    }

    private static void printCommands() {
        System.out.println("Please enter 0 to EXIT");
        System.out.println("Please enter 1 to ADD_COMPANY");
        System.out.println("Please enter 2 to ADD_EMPLOYEE");
        System.out.println("Please enter 3 to PRINT_ALL_COMPANIES");
        System.out.println("Please enter 4 to PRINT_ALL_EMPLOYEES");
        System.out.println("Please enter 5 to SEARCH_EMPLOYEE_BY_ID");
        System.out.println("Please enter 6 to SEARCH_EMPLOYEE_BY_COMPANY");
        System.out.println("Please enter 7 to DELETE_COMPANY");
        System.out.println("Please enter 8 to DELETE_EMPLOYEE");
        System.out.println("Please enter 9 to CHANGE_COMPANY");
        System.out.println("Please enter 10 to CHANGE_EMPLOYEE");



    }
}
