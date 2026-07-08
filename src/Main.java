import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n==============================");
            System.out.println("      PAYROLL SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Employee");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {

                case 1:
                    addEmployee();
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    public static void addEmployee() {

        System.out.println("\nSelect Employee Type");
        System.out.println("1. Intern");
        System.out.println("2. Developer");
        System.out.println("3. Manager");
        System.out.print("Choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Employee Surname: ");
        String surname = scanner.nextLine();

        System.out.print("Employee Number: ");
        String employeeNumber = scanner.nextLine();

        System.out.print("Basic Salary: ");
        double baseSalary = scanner.nextDouble();

        switch (choice) {

            case 1:

                Intern intern = new Intern(
                        name,
                        surname,
                        employeeNumber,
                        baseSalary
                );

                intern.calculateSalary();

                employees.add(intern);

                System.out.println("\nIntern added successfully!");
                break;
            case 2:
                System.out.print("Bonus: ");
                double developerBonus = scanner.nextDouble();

                Developer developer = new Developer(name, surname, employeeNumber, baseSalary, developerBonus);

                developer.calculateSalary();

                employees.add(developer);

                System.out.println("\nDeveloper added successfully!");
                break;

            case 3:

                System.out.print("Bonus: ");
                double managerBonus = scanner.nextDouble();

                System.out.print("Allowance: ");
                double allowance = scanner.nextDouble();

                Manager manager = new Manager(name, surname, employeeNumber, baseSalary, managerBonus, allowance);

                manager.calculateSalary();

                employees.add(manager);

                System.out.println("\nManager added successfully!");
                break;

            default:
                System.out.println("Invalid employee type.");
        }
    }

}