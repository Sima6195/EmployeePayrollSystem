public class Manager extends Employee {
    private double bonus;
    private double allowance;

    public Manager(String employeeName,
                     String employeeSurname,
                     String employeeNumber,
                     double baseSalary) {

        super(employeeName, employeeSurname, employeeNumber, "Manager", baseSalary);

        this.bonus = baseSalary;
        this.allowance = baseSalary;
    }

    public void calculateSalary() {
        double totalSalary = getBasicSalary() + bonus + allowance;
        setSalary(totalSalary);
    }
}
