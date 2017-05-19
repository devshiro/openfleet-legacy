package tests.repository;

import com.markbudai.openfleet.dao.repositories.TransferCostRepository;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.TransferCost;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TransferCostRepositoryTest {

    private static EntityManager entityManager;
    private static TransferCostRepository transferCostRepository;

    @BeforeClass
    public static void setup(){
        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(TransferCost.class,99)).thenReturn(null);
        transferCostRepository = new TransferCostRepository(entityManager);
    }

    @Test(expected = NotFoundException.class)
    public void exceptionWhenNoTransferCostFound(){
        transferCostRepository.getCostById(99);
    }
}
