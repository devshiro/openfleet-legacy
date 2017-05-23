package tests.controller;

import com.markbudai.openfleet.controller.IndexController;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import java.security.Principal;

/**
 * Created by Mark on 2017. 05. 17..
 */
public class IndexControllerTest {
    private static IndexController controller;
    private static Model mockedModel;
    private static Principal mockedPrincipal;

    @BeforeClass
    public static void init() {
        controller = new IndexController();
        mockedModel = Mockito.mock(Model.class);
        mockedPrincipal = Mockito.mock(Principal.class);
    }
    @Test
    public void IndexServesIndexPage(){
        Assert.assertEquals("index",controller.index(mockedModel,mockedPrincipal));
    }
}
