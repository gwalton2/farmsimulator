package farmsim;

import org.junit.Test;
import static org.junit.Assert.*;

public class mainTest {
    @Test
    public void testTestMethod(){
        Main main = new Main();
        assertEquals(main.testMethod(), true);
    }
}
