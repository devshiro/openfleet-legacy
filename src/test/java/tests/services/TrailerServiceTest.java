package tests.services;

import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.dao.repositoryImplementations.TrailerRepositoryJPA;
import com.markbudai.openfleet.model.Trailer;
import com.markbudai.openfleet.pojo.SupervisionDetails;
import com.markbudai.openfleet.services.implementations.TrailerServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import tests.supplier.TrailerSupplier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TrailerServiceTest {
    private static TrailerRepository trailerRepository;
    private static TrailerServiceImpl service;

    @BeforeClass
    public static void init(){
        trailerRepository = Mockito.mock(TrailerRepositoryJPA.class);
        List<Trailer> trailerList = new ArrayList<>();
        trailerList.add(TrailerSupplier.getSampleTrailer());
        Mockito.when(trailerRepository.getAll()).thenReturn(trailerList);
        service = new TrailerServiceImpl(trailerRepository);
    }

    @Test
    public void oneTrailerInSupervisionList(){
        List<SupervisionDetails> details = service.getSupervisionList();
        Assert.assertEquals(1,details.size());
    }

    @Test
    public void trailerNeedsToBeInspectedIn7Days(){
        List<SupervisionDetails> details = service.getSupervisionList();
        Assert.assertEquals(7,details.get(0).getDaysRemaining());
    }
}
