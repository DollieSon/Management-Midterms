public abstract class Person {
    private final String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public void birthday(){
        System.out.printf("Happy birthday, %s!%n",name);
        age++;
    }

    public abstract void performTask();

    @Override
    public String toString() {
        return String.format("%s (%d)",name,age);
    }
}
