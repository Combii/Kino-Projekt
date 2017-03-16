import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by David Stovlbaek
 * 14 March 2017.
 */
public class MainTest extends TestCase {

    @Test
    public void testJunitTest() throws Exception {
        assertEquals(Main.junitTest(), true);

    }

}