package project1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    String name;
    int id;
    String desig;
    int salary;

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public String getDesig() {
        return desig;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getDept() {
        return dept;
    }
    String dept;
   
    public Employee() {
        super();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}