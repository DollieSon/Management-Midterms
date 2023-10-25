public class Employee extends Person {

    private double salary;

    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }

    protected void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public void performTask() {
        System.out.printf("%s is working%n",getName());
    }

    @Override
    public String toString() {
        return super.toString() + " - " + getSalary();
    }
}