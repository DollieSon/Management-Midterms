public class Developer extends Employee{
    Manager ProjectManager;
    public Developer(String name, int age, double salary, Manager projectManager) {
        super(name, age, salary);
        ProjectManager = null;
    }

    public Manager getProjectManager() {
        return ProjectManager;
    }

    protected void setProjectManager(Manager projectManager) {
        if(getProjectManager() != null){
            System.out.printf("%s already has a manager%n",getName());
            return;
        }
        ProjectManager = projectManager;
    }
    public void removePM(){
        ProjectManager = null;
    }

    @Override
    public void birthday() {
        super.birthday();
        if(ProjectManager != null){
            ProjectManager.giveRaise(this, getSalary()*0.05 );
        }
    }

    @Override
    public void performTask() {
        System.out.printf("%s is coding%n",getName());
    }

    @Override
    public String toString() {
        if(ProjectManager != null){
            return super.toString() + String.format(" [%s]",ProjectManager.getName());
        }
        return super.toString();
    }
}
