
import java.util.ArrayList;
import java.util.Scanner;

public class SearchEmployee {

    public void searchEmployee(ArrayList<Employee> employees, Scanner input) {


        System.out.print("Enter employee number to search: ");
        String employeeNumber = input.nextLine();

        boolean found = false;

        for (Employee employee : employees) {

            if (employee.getEmployeeNumber().equalsIgnoreCase(employeeNumber)) {

                System.out.println("\nEmployee found:");
                System.out.println("Name: " + employee.getEmployeeName());
                System.out.println("Surname: " + employee.getEmployeeSurname());
                System.out.println("Employee Number: " + employee.getEmployeeNumber());
                System.out.println("Position: " + employee.getPosition());
                System.out.println("Base Salary: R" + employee.getBasicSalary());

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("\nEmployee not found.");
        }
    }

    // Temporary testing section
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee(
                "John",
                "Smith",
                "EMP001",
                "Manager",
                45000.00git
        ));

        employees.add(new Employee(
                "Sarah",
                "Johnson",
                "EMP002",
                "Intern",
                32000.00
        ));

        employees.add(new Employee(
                "Michael",
                "Brown",
                "EMP003",
                "Developer",
                40000.00
        ));

        SearchEmployee search = new SearchEmployee();

        search.searchEmployee(employees, input);

        input.close();
    }
}
