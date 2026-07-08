public class Developer extends Employee {

    private double bonus;

    public Developer(String employeeName,
                  String employeeSurname,
                  String employeeNumber,
                  double baseSalary) {

        super(employeeName, employeeSurname, employeeNumber, "Developer", baseSalary);

        this.bonus = baseSalary;
    }

   @Override
    public void calculateSalary() {
        double totalSalary = getBasicSalary() + bonus;
        setSalary(totalSalary);
    }
}
