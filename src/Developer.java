public class Developer extends Employee {

    private double bonus;

    public Developer(String employeeName,
                     String employeeSurname,
                     String employeeNumber,
                     double baseSalary,
                     double bonus) {

        super(employeeName, employeeSurname, employeeNumber, "Developer", baseSalary);

        this.bonus = bonus;
    }

   @Override
    public void calculateSalary() {
        double totalSalary = getBasicSalary() + bonus;
        setSalary(totalSalary);
    }
}
