package del2;

import org.junit.jupiter.api.Test;

import static com.company.Rovar.enrov;
import static del2.Convert.*;
import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {
    private Convert convert = new Convert();

    @Test
    void toDegrees() {
        assertEquals(convert.toDegrees(30, 15, 50), ("30,26388888888889"));
    }

    @Test
    void toDMS() { //DMS = Degrees, Minutes, Seconds
        assertEquals(convert.toDMS("30.26388888888889"), ("30 15 50"));
    }


    /*
    @Test
    void random() {
        String str = convert.toDegrees(16, 8, 4);
        System.out.println(str);
        String correctStr = str.replace(',', '.');
        assertEquals(convert.toDMS(correctStr), ("16 8 4"));
    }*/



}