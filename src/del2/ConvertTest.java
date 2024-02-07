package del2;

import org.junit.Test;

import static com.company.Rovar.enrov;
import static del2.Convert.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {

    @org.junit.jupiter.api.Test
    public void testEnrovEmptyString() {
        // Test with empty string
        assertEquals(Convert.toDegrees(30, 15, 50), ("30,263888889°"));
    }

    @org.junit.jupiter.api.Test
    public void test2() {
        // Test with empty string
        assertEquals(Convert.toDMS("30.263888889"), ("30° 15' 50''"));
    }



}