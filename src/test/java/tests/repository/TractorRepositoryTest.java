package tests.repository;

import com.markbudai.openfleet.dao.repositories.TractorRepository;
import com.markbudai.openfleet.dao.repositoryImplementations.TractorRepositoryJPA;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Tractor;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TractorRepositoryTest {
    private static TractorRepository tractorRepository;
    private static EntityManager entityManager;

    @BeforeClass
    public static void init(){
        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(Tractor.class,99)).thenReturn(null);
        tractorRepository = new TractorRepositoryJPA(entityManager);
    }

    @Test(expected = NotFoundException.class)
    public void exceptionThrownWhenNoTractorFound(){
        tractorRepository.getTractorById(99);
    }
}
