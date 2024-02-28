package homework.employeemanagement;

public interface Command {
    String EXIT = "0";
    String ADD_COMPANY = "1";
    String ADD_EMPLOYEE = "2";
    String PRINT_ALL_COMPANIES = "3";
    String PRINT_ALL_EMPLOYEES = "4";
    String SEARCH_EMPLOYEE_BY_ID = "5";
    String SEARCH_EMPLOYEE_BY_COMPANY = "6";
    String DELETE_COMPANY = "7";
    String DELETE_EMPLOYEE = "8";
    String CHANGE_COMPANY = "9";
    String CHANGE_EMPLOYEE = "10";
    static void printCommands() {
        System.out.println("Please enter "+EXIT+" to EXIT");
        System.out.println("Please enter "+ADD_COMPANY+" to ADD_COMPANY");
        System.out.println("Please enter "+ADD_EMPLOYEE+" to ADD_EMPLOYEE");
        System.out.println("Please enter "+PRINT_ALL_COMPANIES+" to PRINT_ALL_COMPANIES");
        System.out.println("Please enter "+PRINT_ALL_EMPLOYEES+" to PRINT_ALL_EMPLOYEES");
        System.out.println("Please enter "+SEARCH_EMPLOYEE_BY_ID+" to SEARCH_EMPLOYEE_BY_ID");
        System.out.println("Please enter "+SEARCH_EMPLOYEE_BY_COMPANY+" to SEARCH_EMPLOYEE_BY_COMPANY");
        System.out.println("Please enter "+DELETE_COMPANY+" to DELETE_COMPANY");
        System.out.println("Please enter "+DELETE_EMPLOYEE+" to DELETE_EMPLOYEE");
        System.out.println("Please enter "+CHANGE_COMPANY+" to CHANGE_COMPANY");
        System.out.println("Please enter "+CHANGE_EMPLOYEE+" to CHANGE_EMPLOYEE");
    }
}
