
import java.util.Scanner;

public class Login {

    private final int maximumAttempts = 3;

    public boolean login(Scanner input, Employee employee) {

        int attempts = 0;

        while (attempts < maximumAttempts) {


            System.out.print("Enter employee name: ");
            String employeeName = input.nextLine();

            System.out.print("Enter employee surname: ");
            String employeeSurname = input.nextLine();

            System.out.print("Enter employee number: ");
            String employeeNumber = input.nextLine();

            boolean correctName =
                    employeeName.equalsIgnoreCase(employee.getEmployeeName());

            boolean correctSurname =
                    employeeSurname.equalsIgnoreCase(employee.getEmployeeSurname());

            boolean correctEmployeeNumber =
                    employeeNumber.equalsIgnoreCase(employee.getEmployeeNumber());

            if (correctName && correctSurname && correctEmployeeNumber) {
                System.out.println("\nLogin successful. Welcome, "
                        + employee.getEmployeeName() + " "
                        + employee.getEmployeeSurname() + "!");
                return true;
            }

            attempts++;

            int attemptsLeft = maximumAttempts - attempts;

            if (attemptsLeft > 0) {
                System.out.println("\nIncorrect employee details.");
                System.out.println("Attempts remaining: " + attemptsLeft);
            }
        }

        System.out.println("\nToo many incorrect login attempts.");
        System.out.println("Access denied.");
        return false;
    }

    public void exitSystem() {
        System.out.println("Thank you for using the Employee Payroll System.");
        System.out.println("Have a good one!");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Sample employee for testing
        Employee emp1 = new Employee(
                "John",
                "Smith",
                "EMP001",
                "Manager",
                45000.00
        );

        Login login = new Login();

        boolean loggedIn = login.login(input, emp1);

        if (loggedIn) {
            System.out.println("Employee payroll system is ready to use.");
        }

        login.exitSystem();

        input.close();
    }
}

