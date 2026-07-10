import javax.swing.text.Position;
import java.util.Scanner;

public class Employee {


    private String employeeName;
    private String employeeSurname;
    private String employeeNumber;
    private String position;
    private double salary;
    private double baseSalary;

    // constructor
    public Employee(String employeeName, String employeeSurname, String employeeNumber, String position, double baseSalary) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeeNumber = employeeNumber;
        this.position = position;
        this.baseSalary = baseSalary;
    }
//getters
        public String getEmployeeName () {
            return employeeName;
        }
        public String getEmployeeSurname () {
            return employeeSurname;
        }
        public String getEmployeeNumber () {
            return employeeNumber;
        }
        public String getPosition () {
            return position;
        }

        public double getBasicSalary () {
        return baseSalary;
        }

        public void setSalary(double salary) {
        this.salary = salary;
        }
//        added getMethod
    public double getSalary() {
        return salary;
    }

        public void calculateSalary() {
            setSalary(getBasicSalary());
        }

        // Tester//



//    public class Main {
        public static void main(String[] args) {

            Scanner input = new Scanner(System.in);
            Employee emp1 = new Employee(
                    "John",
                    "Smith",
                    "EMP001",
                    "Manager",
                    45000.00);
            System.out.println("Employee 1");
            System.out.println("Name: " + emp1.getEmployeeName());
            System.out.println("Surname: " + emp1.getEmployeeSurname());
            System.out.println("Number: " + emp1.getEmployeeNumber());
            System.out.println("Position: " + emp1.getPosition());
            System.out.println("Base Salary: " + emp1.getBasicSalary());

        }
//    Employee emp2 = new Employee(
//            "Sarah",
//            "Johnson",
//            "EMP002",
//            "Intern",
//            32000.00
//    );
//
//    Employee emp3 = new Employee(
//            "Michael",
//            "Brown",
//            "EMP003",
//            "Software Developer",
//            40000.00
//    );

}






