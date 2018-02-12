import com.sav.background.BackBootstrap;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by kaikai on 2018/1/14.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = BackBootstrap.class)
@WebMvcTest
public class BaseUnitTest {
}
