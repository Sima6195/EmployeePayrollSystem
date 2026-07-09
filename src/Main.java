import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //  A list of  default (already saved) employees.
    public static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        employees.add(new Developer(
                "Mpho",
                "Baloyi",
                "EMP001",
                30000,
                5000
        ));

        employees.add(new Manager(
                "Sarah",
                "Jabulani",
                "EMP002",
                45000,
                7000,
                3000
        ));

        employees.add(new Intern(
                "Dineo",
                "Brown",
                "EMP003",
                18000
        ));

        do {

            System.out.println("\n=================================");
            System.out.println("     EMPLOYEE PAYROLL SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("\n========== ADD EMPLOYEE ==========");

                    System.out.print("Enter Employee Name: ");
                    String employeeName = scanner.nextLine();
                    // Validate employee name format
                    if (!employeeName.matches("[a-zA-Z]+")) {
                        System.out.println("Invalid name!");
                        System.out.println("Name should contain letters only.");
                        break;
                    }

                    System.out.print("Enter Employee Surname: ");
                    String employeeSurname = scanner.nextLine();
                    // Validate employee surname format
                    if (!employeeSurname.matches("[a-zA-Z]+")) {
                        System.out.println("Invalid surname!");
                        System.out.println("Surname should contain letters only.");
                        break;
                    }
                    System.out.print("Enter Employee Number: ");
                    String employeeNumber = scanner.nextLine();
                    // Validate employee number format
                    if (!employeeNumber.matches("EMP\\d{3}")) {
                        System.out.println("Invalid Employee Number!");
                        System.out.println("Employee Number must be in the format EMP001.");
                        break;
                    }
//                   Error handling for same Employee number
                    boolean employeeExists = false;

                    for (Employee employee : employees) {

                        if (employee.getEmployeeNumber().equalsIgnoreCase(employeeNumber)) {
                            employeeExists = true;
                            break;
                        }

                    }
                    if (employeeExists) {
                        System.out.println("Employee Number already exists!");
                        break;
                    }

                    System.out.print("Enter Base Salary: ");
                    double baseSalary = scanner.nextDouble();

                    System.out.println("\nSelect Employee Position");
                    System.out.println("1. Developer");
                    System.out.println("2. Manager");
                    System.out.println("3. Intern");
                    System.out.print("Choice: ");

                    int employeeType = scanner.nextInt();

                    switch (employeeType) {

                        case 1:

                            System.out.print("Enter Bonus: ");
                            double devBonus = scanner.nextDouble();

                            Developer developer = new Developer(
                                    employeeName,
                                    employeeSurname,
                                    employeeNumber,
                                    baseSalary,
                                    devBonus
                            );

                            developer.calculateSalary();

                            // Save employee
                            employees.add(developer);

                            System.out.println("\n===== DEVELOPER ADDED SUCCESSFULLY =====");
                            System.out.println("Employee Position : " + developer.getPosition());
                            System.out.println("Name              : " + developer.getEmployeeName());
                            System.out.println("Surname           : " + developer.getEmployeeSurname());
                            System.out.println("Employee Number   : " + developer.getEmployeeNumber());
                            System.out.println("Base Salary       : R" + developer.getBasicSalary());
                            System.out.println("Bonus             : R" + devBonus);

                            break;

                        case 2:

                            System.out.print("Enter Bonus: ");
                            double managerBonus = scanner.nextDouble();

                            System.out.print("Enter Allowance: ");
                            double allowance = scanner.nextDouble();

                            Manager manager = new Manager(
                                    employeeName,
                                    employeeSurname,
                                    employeeNumber,
                                    baseSalary,
                                    managerBonus,
                                    allowance
                            );

                            manager.calculateSalary();

                            // Save employee
                            employees.add(manager);

                            System.out.println("\n===== MANAGER ADDED SUCCESSFULLY =====");
                            System.out.println("Employee Position : " + manager.getPosition());
                            System.out.println("Name              : " + manager.getEmployeeName());
                            System.out.println("Surname           : " + manager.getEmployeeSurname());
                            System.out.println("Employee Number   : " + manager.getEmployeeNumber());
                            System.out.println("Base Salary       : R" + manager.getBasicSalary());
                            System.out.println("Bonus             : R" + managerBonus);
                            System.out.println("Allowance         : R" + allowance);

                            break;

                        case 3:

                            Intern intern = new Intern(
                                    employeeName,
                                    employeeSurname,
                                    employeeNumber,
                                    baseSalary
                            );

                            intern.calculateSalary();

                            // Save employee
                            employees.add(intern);

                            System.out.println("\n===== INTERN ADDED SUCCESSFULLY =====");
                            System.out.println("Employee Position : " + intern.getPosition());
                            System.out.println("Name              : " + intern.getEmployeeName());
                            System.out.println("Surname           : " + intern.getEmployeeSurname());
                            System.out.println("Employee Number   : " + intern.getEmployeeNumber());
                            System.out.println("Base Salary       : R" + intern.getBasicSalary());

                            break;

                        default:
                            System.out.println("Invalid Employee Type!");
                    }
                    if (showPostActionMenu(scanner)) {
                        System.out.println("Thank you for using Employee Payroll System.");
                        choice = 5;
                    }
                    break;

                case 2:

                    System.out.println("\n----- Employee List -----");
                    for (Employee emp : employees) {
                        emp.calculateSalary(); // runs the calculation, stores result in "salary"

                        System.out.println("Name: " + emp.getEmployeeName() + " " + emp.getEmployeeSurname());
                        System.out.println("Employee Number: " + emp.getEmployeeNumber());
                        System.out.println("Position: " + emp.getPosition());
                        System.out.println("Base Salary: " + emp.getBasicSalary());
                        System.out.println("Calculated Salary: " + emp.getSalary());
                        System.out.println("--------------------------");
                    }
                    if (showPostActionMenu(scanner)) {
                        System.out.println("Thank you for using Employee Payroll System.");
                        choice = 5;
                    }
                    break;

                case 3:
                    SearchEmployee search = new SearchEmployee();
                    search.searchEmployee(employees, scanner);
                    if (showPostActionMenu(scanner)) {
                        System.out.println("Thank you for using Employee Payroll System.");
                        choice = 5;
                    }
                    break;

                case 4:
                    removeEmployee(scanner);
                    if (showPostActionMenu(scanner)) {
                        System.out.println("Thank you for using Employee Payroll System.");
                        choice = 5;
                    }
                    break;



                case 5:
                    System.out.println("Thank you for using Employee Payroll System.");
                    break;

                default:
                    System.out.println("Invalid menu choice.");
            }

        } while (choice != 5);

        scanner.close();
    }

// Remove Employee method
    public static void removeEmployee(Scanner scanner) {
        if (employees.isEmpty()) {
            System.out.println("No employees to remove.");
            return;
        }

        System.out.print("Enter Employee Number to remove: ");
        String empNumberToRemove = scanner.nextLine();

        Employee foundEmployee = null;

        for (Employee emp : employees) {
            if (emp.getEmployeeNumber().equalsIgnoreCase(empNumberToRemove)) {
                foundEmployee = emp;
                break;
            }
        }

        if (foundEmployee != null) {
            employees.remove(foundEmployee);
            System.out.println("Employee " + foundEmployee.getEmployeeName() + " "
                    + foundEmployee.getEmployeeSurname() + " removed successfully.");
        } else {
            System.out.println("No employee found with number " + empNumberToRemove);
        }


    }

    // Post Action
    public static boolean showPostActionMenu(Scanner scanner) {
        System.out.println("\n1. Back to Menu");
        System.out.println("2. Exit");
        System.out.print("Enter choice: ");

        int postChoice = scanner.nextInt();
        scanner.nextLine(); // clear the leftover newline

        return postChoice == 2;
    }
}