package tests.services;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.services.EmployeeService;
import com.markbudai.openfleet.services.implementations.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.listprovider.EmployeeListProvider;
import tests.supplier.EmployeeSupplier;

import javax.persistence.EntityManager;
import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 26..
 */
public class EmployeeServiceTest {
    private static EmployeeService service;

    @BeforeClass
    public static void init(){
        EmployeeListProvider provider = new EmployeeListProvider();
        provider.add(EmployeeSupplier.getSampleEmployee());
        service = new EmployeeServiceImpl(provider);
    }

    @Test
    public void testAdd(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        employee.setId(999);
        int size = service.getAllEmployees().size();
        service.addEmployee(employee);
        Assert.assertEquals(size+1,service.getAllEmployees().size());
    }

    @Test
    public void testUpdate(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        employee.setId(777);
        service.addEmployee(employee);
        employee = EmployeeSupplier.getSampleEmployee();
        employee.setId(777);
        employee.setFirstName("Samplee");
        Employee diff = service.getEmployeeById(777);
        Assert.assertNotEquals(employee,diff);
        service.updateEmployee(employee);
        Assert.assertEquals("Samplee",service.getEmployeeById(777).getFirstName());
    }

    @Test
    public void testDelete(){
        Employee employee = EmployeeSupplier.getSampleEmployee();
        employee.setEndOfEmploymentDate(null);
        employee.setId(123);
        service.addEmployee(employee);
        service.fireEmployee(123);
        Employee test = service.getEmployeeById(123);
        Assert.assertNotNull(test.getEmploymentDate());
    }

    @Test
    public void testList(){
        EmployeeListProvider provider = new EmployeeListProvider();
        provider.add(EmployeeSupplier.getSampleEmployee());
        service = new EmployeeServiceImpl(provider);
        Employee firedEmployee = EmployeeSupplier.getSampleEmployee();
        firedEmployee.setId(123);
        firedEmployee.setEndOfEmploymentDate(LocalDate.now());
        service.addEmployee(firedEmployee);
        Assert.assertEquals(1,service.getAllEmployees().size());
    }
}
