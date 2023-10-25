public class Customer extends Person{
    public Customer(String name, int age) {
        super(name, age);
    }

    @Override
    public void performTask() {
        System.out.printf("%s is browsing through%n",getName());
    }
    public void Speak(Person employee){
        if(getAge() > employee.getAge() && employee instanceof Developer ){
            if(((Developer) employee).getProjectManager() != null) {
                System.out.printf("Can I see your manager %s?%n", ((Developer) employee).getProjectManager().getName());
                return;
            }
        }
        System.out.printf("Oh, hello, %s. Can you assist me?%n",employee.getName());
    }
}
