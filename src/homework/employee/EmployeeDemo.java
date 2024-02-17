package homework.employee;

import java.util.Scanner;

public class EmployeeDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        EmployeeStorage es = new EmployeeStorage();

        boolean isRunning = true;
        while(isRunning){
            System.out.println("Please enter 0 to EXIT program");
            System.out.println("Please input 1 to ADD an employee");
            System.out.println("Please input 2 to PRINT all employees");
            System.out.println("Please input 3 to SEARCH an employee by ID");
            System.out.println("Please input 4 to SEARCH all employees by company name");
            String command = s.nextLine();
            switch(command){
                case "0":
                    isRunning = false;
                    break;
                case "1":
                    System.out.println("Please enter new employee's ID");
                    String id = s.nextLine();
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
                    Employee e = new Employee(name, lastName, id, salary, company, position );
                    System.out.println("Employee Created!");
                    es.add(e);
                    break;
                case "2":
                    es.print();
                    break;
                case "3":
                    System.out.println("What's employee's ID? ");
                    id = s.nextLine();
                    e = es.search(id);
                    if(e != null){
                        e.print();
                    }else{
                        System.out.println("No such employee");
                    }
                    break;
                case "4":
                    System.out.println("What's company name?");
                    String companyName = s.nextLine();
                    es.searchByCompany(companyName);
                    break;
                default:
                    System.out.println("Invalid command. try again!");

            }
        }

    }
}
