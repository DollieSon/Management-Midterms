public class Manager extends Employee{


    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }

    public void giveRaise(Employee person,double raise){
        if(raise < 0){
            System.out.println("Invalid increase");
            return;
        }
        person.setSalary(person.getSalary() + raise);
        if(person != this){
            setSalary(getSalary() + (raise/2));
        }
    }

    @Override
    public String toString() {
        return "Mgr. " + super.toString();
    }
}
