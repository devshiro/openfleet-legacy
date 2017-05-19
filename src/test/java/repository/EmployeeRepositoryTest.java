package repository;

import com.markbudai.openfleet.dao.repositories.EmployeeRepository;
import com.markbudai.openfleet.exception.NoEmployeeFoundException;
import com.markbudai.openfleet.model.Employee;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class EmployeeRepositoryTest {
    private static EntityManager mockedEntityManager;
    private static EmployeeRepository employeeRepository;

    @BeforeClass
    public static void setup(){
        mockedEntityManager = Mockito.mock(EntityManager.class);
        Mockito.when(mockedEntityManager.find(Employee.class,99)).thenReturn(null);
        employeeRepository = new EmployeeRepository(mockedEntityManager);
    }

    @Test(expected = NoEmployeeFoundException.class)
    public void exceptionThrownWhenNonExistingIdSupplied(){
        employeeRepository.getEmployeeById(99);
    }
}
