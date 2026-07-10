public class Manager extends Employee {
    private double bonus;
    private double allowance;

    public Manager(String employeeName,
                   String employeeSurname,
                   String employeeNumber,
                   double baseSalary,
                   double bonus,
                   double allowance) {

        super(employeeName, employeeSurname, employeeNumber, "Manager", baseSalary);

        this.bonus = bonus;
        this.allowance = allowance;
    }

    @Override
    public void calculateSalary() {
        double totalSalary = getBasicSalary() + bonus + allowance;
        setSalary(totalSalary);
    }

    public double getAllowance() {
        return allowance;
    }

    public double getBonus() {
        return bonus;
    }
}
