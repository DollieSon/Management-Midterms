import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> persons = new ArrayList<Person>();
        String input, name, name2;
        int age;
        double salary;
        while (true){
            System.out.print("Enter person type: ");
            input = sc.nextLine();
            if (input.equals("DONE")) {
                break;
            }
            switch (input.charAt(0)) {
                case 'c':
                    System.out.print("Enter customer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter customer age: ");
                    age = sc.nextInt();
                    persons.add(new Customer(name,age));
                    break;
                case 'e':
                    System.out.print("Enter employee name: ");
                    name = sc.nextLine();
                    System.out.print("Enter employee age: ");
                    age = sc.nextInt();
                    System.out.print("Enter employee salary: ");
                    salary = sc.nextDouble();
                    persons.add(new Employee(name,age,salary));
                    break;
                case 'd':
                    System.out.print("Enter developer name: ");
                    name = sc.nextLine();
                    System.out.print("Enter developer age: ");
                    age = sc.nextInt();
                    System.out.print("Enter developer salary: ");
                    salary = sc.nextDouble();
                    persons.add(new Developer(name,age,salary,null));
                    break;
                case 'm':
                    System.out.print("Enter manager name: ");
                    name = sc.nextLine();
                    System.out.print("Enter manager age: ");
                    age = sc.nextInt();
                    System.out.print("Enter manager salary: ");
                    salary = sc.nextDouble();
                    persons.add(new Manager(name,age,salary));
                    break;

                // TODO add more cases for other Person subclasses here
            }
            sc.nextLine();
        }
        while (true) {
            System.out.print("Enter action: ");
            input = sc.nextLine();
            switch (input) {
                case "DONE":
                    return;
                case "Birthday":
                    boolean found = false;
                    System.out.print("Whose birthday? ");
                    name = sc.nextLine();
                    // TODO find name and call birthday
                    for(Person person : persons){
                        if(person.getName().compareTo(name) == 0){
                            person.birthday();
                            found = true;
                        }
                    }
                    if(!found){
                        System.out.println("Invalid input");
                    }
                    break;
                case "Assign PM":
                    found = false;
                    System.out.print("Select developer: ");
                    name = sc.nextLine();
                    System.out.print("Select manager: ");
                    name2 = sc.nextLine();
                    for(Person person : persons){
                        if(person instanceof Developer && person.getName().compareTo(name) == 0){
                            if(name2.compareTo("NULL") == 0) {
                                ((Developer)person).removePM();
                                found = true;
                                break;
                            }
                            for (Person manager: persons) {
                                if (manager.getName().compareTo(name2) == 0 && manager instanceof Manager) {
                                    ((Developer)person).setProjectManager((Manager) manager);
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!found){
                        System.out.println("Invalid input");
                    }
                    break;
                case "Perform Task":
                    for(Person person:persons){
                        person.performTask();
                    }
                    break;
                case "Give Raise":
                    found = false;
                    System.out.print("Enter manager: ");
                    name2 = sc.nextLine();
                    System.out.print("Enter employee: ");
                    name = sc.nextLine();
                    System.out.print("Enter increase: ");
                    salary = sc.nextDouble();
                    sc.nextLine();
                    for(Person person : persons){
                        if(person instanceof Employee && person.getName().compareTo(name) == 0){
                            for (Person manager: persons) {
                                if (manager.getName().compareTo(name2) == 0 && manager instanceof Manager) {
                                    ((Manager)manager).giveRaise((Employee) person,salary);
                                    found = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!found){
                        System.out.println("Invalid input");
                    }
                    break;
                case "Customer Speak":
                    found = false;
                    System.out.print("Select customer: ");
                    name2 = sc.nextLine();
                    System.out.print("Select employee: ");
                    name = sc.nextLine();
                    for(Person person : persons){
                        if(person instanceof Employee && person.getName().compareTo(name) == 0){
                            for (Person manager: persons) {
                                if (manager.getName().compareTo(name2) == 0 && manager instanceof Customer) {
                                    ((Customer)manager).Speak(person);
                                    found =true;
                                    break;
                                }
                            }
                        }
                    }
                    if(!found){
                        System.out.println("Invalid input");
                    }
                    break;
                case "Person List":
                    int count =0;
                    for (Person person:persons){
                        System.out.println(person);
                        count++;
                    }
                    if(count == 0){
                        System.out.println("No persons in list");
                    }else{
                        System.out.printf("Total Count: %d%n",count);
                    }
                    break;
                case "Developer List":
                    count =0;
                    for (Person person:persons){
                        if(person instanceof Developer){
                            System.out.println(person);
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("No developers in list");
                    }else{
                        System.out.printf("Total Count: %d%n",count);
                    }
                    break;
                case "Manager List":
                    count =0;
                    for (Person person:persons){
                        if(person instanceof Manager){
                            System.out.println(person);
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("No managers in list");
                    }else{
                        System.out.printf("Total Count: %d%n",count);
                    }
                    break;
                case "Employee List":
                    count =0;
                    for (Person person:persons) {
                        if (person instanceof Employee) {
                            System.out.println(person);
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("No customers in list");
                    }else{
                        System.out.printf("Total Count: %d%n",count);
                    }
                    break;
                case "Customer List":
                    count =0;
                    for (Person person:persons){
                        if(person instanceof Customer){
                            System.out.println(person);
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("No customers in list");
                    }else{
                        System.out.printf("Total Count: %d%n",count);
                    }
                    break;

                // TODO add more action cases here
                default:
                    System.out.println("Invalid action");
            }
            input = "";
        }
    }

}