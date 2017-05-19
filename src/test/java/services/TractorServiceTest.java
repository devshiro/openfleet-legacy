package services;

import com.markbudai.openfleet.dao.providers.TractorProvider;
import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.model.Tractor;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import com.markbudai.openfleet.services.TractorService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import supplier.TractorSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TractorServiceTest {

    private static TractorRepository tractorRepository;
    private static TractorService service;

    @BeforeClass
    public static void setup(){
        tractorRepository = Mockito.mock(TractorRepository.class);
        List<Tractor> tractorList = new ArrayList<>();
        tractorList.add(TractorSupplier.getSampleTractor());
        Mockito.when(tractorRepository.getAllTractors()).thenReturn(tractorList);
        service = new TractorService(tractorRepository);
    }

    @Test
    public void oneTruckInSupervisionList(){
        List<SupervisionDetails> details = service.getSupervisionList();
        Assert.assertEquals(1,details.size());
    }

    @Test
    public void truckNeedsToBeInspectedIn7Days(){
        List<SupervisionDetails> details = service.getSupervisionList();
        Assert.assertEquals(7,details.get(0).getDays_remaining());
    }
}
