package tests.repository;

import com.markbudai.openfleet.dao.repositories.TrailerRepository;
import com.markbudai.openfleet.dao.repositoryImplementations.TrailerRepositoryJPA;
import com.markbudai.openfleet.exception.NotFoundException;
import com.markbudai.openfleet.model.Trailer;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class TrailerRepositoryTest {

    private static TrailerRepository trailerRepository;
    private static EntityManager entityManager;

    @BeforeClass
    public static void init(){
        entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(Trailer.class,99)).thenReturn(null);
        trailerRepository = new TrailerRepositoryJPA(entityManager);
    }

    @Test(expected = NotFoundException.class)
    public void exceptionWhenNoTrailerFound(){
        trailerRepository.getById(99);
    }
}
