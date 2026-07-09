import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("   EMPLOYEE PAYROLL SYSTEM");
        System.out.println("=================================");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Search Employee");
        System.out.println("5. Remove Employee");
        System.out.println("6. Exit");
        System.out.print("\nEnter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {

            case 1:

                System.out.println("\n========== ADD EMPLOYEE ==========");

                System.out.print("Enter Employee Name: ");
                String employeeName = scanner.nextLine();

                System.out.print("Enter Employee Surname: ");
                String employeeSurname = scanner.nextLine();

                System.out.print("Enter Employee Number: ");
                String employeeNumber = scanner.nextLine();

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

                break;

            case 2:
                System.out.println("View Employees feature coming soon...");
                break;

            case 3:
                System.out.println("Search Employee feature coming soon...");
                break;

            case 4:
                System.out.println("Calculate Payroll feature coming soon...");
                break;

            case 5:
                System.out.println("Remove Employee feature coming soon...");
                break;

            case 6:
                System.out.println("Thank you for using Employee Payroll System.");
                break;

            default:
                System.out.println("Invalid menu choice.");
        }

        scanner.close();
    }
}