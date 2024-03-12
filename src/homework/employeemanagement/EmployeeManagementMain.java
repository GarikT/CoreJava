package homework.employeemanagement;

import homework.employeemanagement.exception.EmployeeNotFoundException;
import homework.employeemanagement.model.Company;
import homework.employeemanagement.model.Employee;
import homework.employeemanagement.storage.CompanyStorage;
import homework.employeemanagement.storage.EmployeeStorage;
import homework.employeemanagement.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class EmployeeManagementMain implements Command {
    private static Scanner scanner = new Scanner(System.in);
    private static EmployeeStorage employeeStorage = new EmployeeStorage();
    private static CompanyStorage companyStorage = new CompanyStorage();
    public static void main(String[] args) throws ParseException {
        boolean isRunning = true;
        while(isRunning){
            Command.printCommands();
            String command = scanner.nextLine();
            switch (command){
                case EXIT:
                    isRunning = false;
                    break;
                case ADD_COMPANY:
                    addCompany();
                    break;
                case ADD_EMPLOYEE:
                    addEmployee();
                    break;
                case PRINT_ALL_COMPANIES:
                    companyStorage.print();
                    break;
                case PRINT_ALL_EMPLOYEES:
                    employeeStorage.print();
                    break;
                case SEARCH_EMPLOYEE_BY_ID:
                    searchEmployeeById();
                    break;
                case SEARCH_EMPLOYEE_BY_COMPANY:
                    searchEmployeeByCompany();
                    break;
                case DELETE_COMPANY:
                    deleteCompany();
                    break;
                case DELETE_EMPLOYEE:
                    deleteEmployee();
                    break;
                case CHANGE_COMPANY:
                    changeCompany();
                    break;
                case CHANGE_EMPLOYEE:
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
        try {
            Employee employeeFromStorage = employeeStorage.getById(employeeId);
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
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }catch(NumberFormatException e){
            System.out.println("Wrong salary, please input only numbers!");
        }
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
        try {
            Employee employeeFromStorage = employeeStorage.getById(employeeId);
//            if (employeeFromStorage == null) {
//                System.out.println("Employee with " + employeeId + " does not exists");
//                return;
//            }
            if (!employeeFromStorage.getCompany().equals(companyFromStorage)) {
                System.out.println("Wrong employee id.");
                return;
            }
            employeeStorage.deleteById(employeeId);
        }catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }

    }

    private static void deleteCompany() {
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
        try {
            System.out.println(employeeStorage.getById(employeeId));
        }catch(EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

    private static void addEmployee() throws ParseException {
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
        boolean exists;
        try {
            employeeStorage.getById(employeeId);
            exists = true;
        }catch (EmployeeNotFoundException e) {
            exists = false;
        }
        if(!exists){
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
            System.out.println("Please enter employee birth date (dd-MM-yyyy)");
            String dateOfBirthStr = scanner.nextLine();
            Date dateOfBirth = DateUtil.stringToDate(dateOfBirthStr);
            Date registerDate = new Date();
            Employee employee = new Employee(employeeId, employeeName, employeeSurname, employeePhoneNumber, employeeSalary, employeePosition, companyFromStorage, dateOfBirth, registerDate);
            employeeStorage.add(employee);
            System.out.println("Employee Registered");
        }else{
            System.out.println("Employee already exists!");
        }
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
        Company company = new Company(companyId, companyName, companyAddress);
        companyStorage.add(company);
        System.out.println("Company registered");
    }


}
