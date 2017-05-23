package tests.supplier;

import com.markbudai.openfleet.services.EmployeeService;
import com.markbudai.openfleet.model.Employee;
import org.mockito.Mockito;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 13..
 */
public class EmployeeSupplier {
    public static Employee getSampleEmployee(){
        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("John");
        employee.setLastName("Shepard");
        employee.setDateOfBirth(LocalDate.of(1993,01,01));
        employee.setSocialInsuranceNo("1");
        employee.setTaxNo("1");
        employee.setMothersName("Jane Doe");
        employee.setDriversCardNo("2");
        employee.setPlaceOfLiving(LocationSupplier.getSampleLocation());
        employee.setPlaceOfBirth(LocationSupplier.getSampleLocation());
        employee.setEmploymentDate(LocalDate.of(2017,05,18));
        return employee;
    }

    public static EmployeeService getMockProvider(){
        EmployeeService employeeService = Mockito.mock(EmployeeService.class);
        Mockito.when(employeeService.getEmployeeById(1)).thenReturn(getSampleEmployee());
        return employeeService;
    }
}
