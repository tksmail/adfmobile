package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;


@Path("project1")
public class EmployeeService {

    private static List<Employee> employeeList = new CopyOnWriteArrayList<Employee>();

    public EmployeeService() {
        addEmp();
    }

    @GET
    @Produces("application/json")
    public EmployeeList getEmpList() {       
        return new EmployeeList(employeeList);
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public EmployeeList addEmployee(Employee emp) {
        employeeList.add(emp);
        return new EmployeeList(employeeList);
    }

    @DELETE
    @Produces("application/json")
    public EmployeeList deleteEmployee(@QueryParam("name") String name) {
        employeeList.remove(getEmp(name));
        return new EmployeeList(employeeList);
    }
    
    @POST
    @Produces("application/json")
    public EmployeeList updateEmployee(@QueryParam("id") int id,@QueryParam("name") String name) {
        Employee emp1 = new Employee();
        emp1 = getEmpById(id);
        if(emp1 != null)
            emp1.setName(name);
        return new EmployeeList(employeeList);
    }

    public Employee getEmp(String name) {
        Iterator i = employeeList.iterator();
        while (i.hasNext()) {
            Employee e = (Employee)i.next();
            if (e.getName().equalsIgnoreCase(name))
                return e;
        }
        return null;
    }


    @GET
    @Produces("application/json")
    @Path("/getById/{id}")
    public Employee getEmpById(@PathParam("id") int id) {
        Iterator i = employeeList.iterator();
        while (i.hasNext()) {
            Employee e = (Employee)i.next();
            if (e.getId() == id)
                return e;
        }
        return null;
    }

    public void addEmp() {
        if (employeeList.isEmpty()) {
            Employee emp1 = new Employee();
            emp1.setId(1);
            emp1.setName("Arnold");
            emp1.setDept("IT");
            emp1.setDesig("Director");
            emp1.setSalary(80000);
            employeeList.add(emp1);
            Employee emp2 = new Employee();
            emp2.setId(2);
            emp2.setName("Myra");
            emp2.setDept("HR");
            emp2.setDesig("Officer");
            emp2.setSalary(5000);
            employeeList.add(emp2);
        }
    }
}
