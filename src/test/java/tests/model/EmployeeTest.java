package tests.model;

import com.markbudai.openfleet.model.Employee;
import com.markbudai.openfleet.model.Location;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import tests.supplier.EmployeeSupplier;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 20..
 */
public class EmployeeTest {
    private static Employee one;
    private static Employee two;

    @BeforeClass
    public static void setup(){
        one = EmployeeSupplier.getSampleEmployee();
        two = EmployeeSupplier.getSampleEmployee();
    }

    @Before
    public void reset(){
        setup();
    }

    @Test
    public void notEqualIfFirstNameDifferent(){
        one.setFirstName("A");
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfLastNameDifferent(){
        one.setLastName("A");
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfDateOfBirthDifferent(){
        one.setDateOfBirth(LocalDate.now());
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfPlaceOfBirthDifferent(){
        one.setPlaceOfBirth(new Location());
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfSocialNoDifferent(){
        one.setSocialInsuranceNo("A");
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfMothersNameDifferent(){
        one.setMothersName("A");
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfTaxNoDifferent(){
        one.setTaxNo("A");
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfDriversCardNoDifferent(){
        one.setDriversCardNo("A");
        Assert.assertFalse(one.equals(two));
    }

    @Test
    public void notEqualIfPlaceOfLivingDifferent(){
        one.setPlaceOfLiving(new Location());
        Assert.assertFalse(one.equals(two));
    }
}
