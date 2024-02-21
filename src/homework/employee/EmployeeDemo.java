package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    static Scanner s = new Scanner(System.in);
    static EmployeeStorage es = new EmployeeStorage();
    static boolean isRunning = true;
    static String id;
    static Employee e;
    public static void main(String[] args) {

        while(isRunning){
            printMenu();
            String command = s.nextLine();
            switch(command){
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    caseOne();
                    break;
                case "2":
                    es.print();
                    break;
                case "3":
                    caseThree();
                    break;
                case "4":
                    caseFour();
                    break;
                case "5":
                    caseFive();
                    break;
                case "6":
                    caseSix();
                    break;
                default:
                    System.out.println("Invalid command. try again!");

            }
        }

    }
    static void printMenu(){
        System.out.println("Please enter 0 to EXIT program");
        System.out.println("Please input 1 to ADD an employee");
        System.out.println("Please input 2 to PRINT all employees");
        System.out.println("Please input 3 to SEARCH an employee by ID");
        System.out.println("Please input 4 to SEARCH all employees by company name");
        System.out.println("Please input 5 to DELETE an employee by ID");
        System.out.println("Please input 6 to CHANGE employee data");
    }
    static void caseOne(){
        System.out.println("Please enter new employee's ID");
        id = s.nextLine();
        System.out.println("Please enter new employee's first name");
        String name = s.nextLine();
        System.out.println("Please enter new employee's last name");
        String lastName = s.nextLine();
        System.out.println("Please enter company name");
        String company = s.nextLine();
        System.out.println("Please enter new employee's position in " + company);
        String position = s.nextLine();
        System.out.println("Please enter new employee's salary");
        double salary = Double.parseDouble(s.nextLine());
        e = new Employee(name, lastName, id, salary, company, position );
        System.out.println("Employee Created!");
        es.add(e);
    }
    static void caseThree(){
        System.out.println("What's employee's ID? ");
        id = s.nextLine();
        e = es.search(id);
        if(e != null){
            e.print();
        }else{
            System.out.println("No such employee");
        }
    }
    static void caseFour(){
        System.out.println("What's company name?");
        String companyName = s.nextLine();
        es.searchByCompany(companyName);
    }

    static void caseFive(){
        System.out.println("What's the ID of employee you want to delete?");
        id =  s.nextLine();
        es.deleteByID(id);
    }
    static void caseSix(){
        System.out.println("What's the ID of employee you what to change?");
        id = s.nextLine();
        int intID = es.findByID(id);
        es.changeByID(intID);
    }
}
