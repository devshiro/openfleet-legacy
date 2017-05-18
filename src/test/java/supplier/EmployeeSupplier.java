package supplier;

import com.markbudai.openfleet.model.Employee;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class EmployeeSupplier {
    public static Employee getSampleEmployee(){
        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Shepard");
        return employee;
    }
}
