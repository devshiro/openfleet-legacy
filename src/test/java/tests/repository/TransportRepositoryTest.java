package tests.repository;

import com.markbudai.openfleet.dao.repositories.TransportRepository;
import com.markbudai.openfleet.dao.repositoryImplementations.TransportRepositoryJPA;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Transport;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TransportRepositoryTest {

    private static EntityManager entityManager;
    private static TransportRepository transportRepository;

    @BeforeClass
    public static void init(){
        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(Transport.class,99)).thenReturn(null);
        transportRepository = new TransportRepositoryJPA(entityManager);
    }

    @Test(expected = NotFoundException.class)
    public void exceptionWhenNoTransportFound(){
        transportRepository.getById(99);
    }

}
