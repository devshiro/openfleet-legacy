package tests.services;

import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.dao.repositoryImplementations.TractorRepositoryJPA;
import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import com.markbudai.openfleet.services.implementations.TractorServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import tests.supplier.TractorSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TractorServiceTest {

    private static TractorRepository tractorRepository;
    private static TractorServiceImpl service;

    @BeforeClass
    public static void setup(){
        tractorRepository = Mockito.mock(TractorRepositoryJPA.class);
        List<Tractor> tractorList = new ArrayList<>();
        tractorList.add(TractorSupplier.getSampleTractor());
        Mockito.when(tractorRepository.getAllTractors()).thenReturn(tractorList);
        service = new TractorServiceImpl(tractorRepository);
    }

    @Test
    public void oneTruckInSupervisionList(){
        List<SupervisionDetails> details = service.getSupervisionList();
        Assert.assertEquals(1,details.size());
    }

    @Test
    public void truckNeedsToBeInspectedIn7Days(){
        List<SupervisionDetails> details = service.getSupervisionList();
        Assert.assertEquals(7,details.get(0).getDaysRemaining());
    }
}
