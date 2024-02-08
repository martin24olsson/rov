package del2;

import org.junit.jupiter.api.Test;

import static junit.framework.TestCase.assertEquals;

class ConvertTest {
    private Convert convert = new Convert();

    @Test
    void toDegrees() {
        assertEquals(convert.toDegrees(30, 15, 36), ("30,26"));
    }

    @Test
    void toDMS() { //DMS = Degrees, Minutes, Seconds
        assertEquals(convert.toDMS("30,26"), ("30 15 36"));
    }



    @Test
    void toDegreesDeg1() {
        assertEquals(convert.toDegrees(-1, 8, 4), ("invalid degrees"));
    }
    @Test
    void toDegreesDeg2() {
        assertEquals(convert.toDegrees(0, 15, 36), ("0,26"));
    }
    @Test
    void toDegreesDeg3() {
        assertEquals(convert.toDegrees(179, 15, 36), ("179,26"));
    }
    @Test
    void toDegreesDeg4() {
        assertEquals(convert.toDegrees(180, 15, 36), ("invalid degrees"));
    }



    @Test
    void toDegreesSec1() {
        assertEquals(convert.toDegrees(30, 15, 60), ("invalid sec"));
    }
    @Test
    void toDegreesSec2() {
        assertEquals(convert.toDegrees(30, 15, 59), ("30,26638888888889"));
    }
    @Test
    void toDegreesSec3() {
        assertEquals(convert.toDegrees(30, 15, 0), ("30,25"));
    }
    @Test
    void toDegreesSec4() {
        assertEquals(convert.toDegrees(30, 15, -1), ("invalid sec"));
    }

    @Test
    void toDegreesMin1() {
        assertEquals(convert.toDegrees(30, 60, 36), ("invalid min"));
    }
    @Test
    void toDegreesMin2() {
        assertEquals(convert.toDegrees(30, 59, 36), ("30,993333333333336"));
    }
    @Test
    void toDegreesMin3() {
        assertEquals(convert.toDegrees(30, 0, 36), ("30,01"));
    }
    @Test
    void toDegreesMin4() {
        assertEquals(convert.toDegrees(30, -1, 36), ("invalid min"));
    }



    @Test
    void BVA1() {
        assertEquals(convert.toDMS("180,00000001"), ("invalid decimal"));
    }
    @Test
    void BVA2() {
        assertEquals(convert.toDMS("180"), ("180 0 0"));
    }

    @Test
    void BVA3() {
        assertEquals(convert.toDMS("-1"), ("invalid decimal"));
    }
    @Test
    void BVA4() {
        assertEquals(convert.toDMS("0"), ("0 0 0"));
    }







    @Test
    void numbersAddUp() {
        String str = convert.toDegrees(10, 9, 16);
        str = str.replace(',', '.');
        String str2 = convert.toDegrees(5, 6, 8);
        str2 = str2.replace(',', '.');
        String str3 = convert.toDegrees(15, 3, 4);
        str3 = str3.replace(',', '.');

        double addUpp = Double.parseDouble(str)
                + Double.parseDouble(str2)
                + Double.parseDouble(str3);

        assertEquals(convert.toDMS(String.valueOf(addUpp)), ("30 18 28"));
    }




}