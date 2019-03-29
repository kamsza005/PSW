import javafx.scene.control.Button;

public class Employee {

    Integer id;
    String name,email,salary;
    Button del;
    public Employee(Integer id, String name, String email, String salary)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.salary=salary;
    }
    public Employee()
    {

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

}
