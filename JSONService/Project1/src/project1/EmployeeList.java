package project1;

import java.net.URI;
import java.net.URL;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class EmployeeList {

    private List<Employee> list = new ArrayList<Employee>();


    public EmployeeList() {

    }

    public EmployeeList(List<Employee> list) {
        super();
        this.list = list;
    }

	@XmlElement
    public List<Employee> getList() {
        return list;
    }
}
