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
    void BVA1() {
        assertEquals(convert.toDegrees(-1, 8, 4), ("illegal"));
    }

    @Test
    void BVA2() {
        String str = convert.toDegrees(12, 0, 14);
        assertEquals(convert.toDMS(str), ("12 0 14"));
    }

    @Test
    void BVA3() {
        String str = convert.toDegrees(18, 3, 0);
        assertEquals(convert.toDMS(str), ("18 3 0"));
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