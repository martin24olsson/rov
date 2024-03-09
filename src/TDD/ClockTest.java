package TDD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ClockTest {
    private Clock clock;

    @BeforeEach
    public void before() {
        clock = new Clock();
    }

    /**
     * Possible state transition tests
     */
    @Test
    public void changeModeDisplayTime() {
        clock.changeMode();
        assertEquals("00:00:00", clock.changeMode());
    }
    @Test
    public void changeModeDisplayDate() {
        assertEquals("2000-1-1", clock.changeMode());
    }
    @Test
    public void readyToSetTime() {
        assertEquals("Give Time", clock.ready());
    }
    @Test
    public void readyToSetDate() {
        clock.changeMode();
        assertEquals("Give Date", clock.ready());
    }
    @Test
    public void setDisplayTime() {
        clock.ready();
        assertEquals("20:20:20", clock.set(20, 20, 20));
    }
    @Test
    public void setDisplayDate() {
        clock.changeMode();
        clock.ready();
        assertEquals("2018-12-12", clock.set(2018, 12, 12));
    }

    /**
     * Invalid state transition tests
     */
    @Test
    void S1_set() {
         assertEquals(clock.set(12, 12, 12), ("Time change failed"));
    }
    @Test
    void S2_set() {
        clock.changeMode();
        assertEquals(clock.set(2010, 12, 12), ("Date change failed"));
    }
    @Test
    void S3_changeMode() {
        clock.ready();
        assertEquals(clock.changeMode(), ("change mode not accessible from change time"));
    }
    @Test
    void S3_ready() {
        clock.ready();
        assertEquals(clock.ready(), ("Already in change time mode"));
    }
    @Test
    void S4_changeMode() {
        clock.changeMode();
        clock.ready();
        assertEquals(clock.changeMode(), ("change mode not accessible from change date"));
    }
    @Test
    void S4_ready() {
        clock.changeMode();
        clock.ready();
        assertEquals(clock.ready(), ("Already in change date mode"));
    }

    /**
     * Test cases for each boundary in the Time object
     */
    @Test
    void testHourAbove(){
        clock.ready();
        assertEquals(clock.set(24, 11, 11), ("invalid hour"));
    }
    @Test
    void testHourUpper(){
        clock.ready();
        assertEquals(clock.set(23, 11, 11), ("23:11:11"));
    }
    @Test
    void testHourLower(){
        clock.ready();
        assertEquals(clock.set(0, 11, 11), ("00:11:11"));
    }
    @Test
    void testHourBelow(){
        clock.ready();
        assertEquals(clock.set(-1, 11, 11), ("invalid hour"));
    }
    @Test
    void testMinAbove(){
        clock.ready();
        assertEquals(clock.set(11, 60, 11), ("invalid minute"));
    }
    @Test
    void testMinUpper(){
        clock.ready();
        assertEquals(clock.set(11, 59, 11), ("11:59:11"));
    }
    @Test
    void testMinLower(){
        clock.ready();
        assertEquals(clock.set(11, 0, 11), ("11:00:11"));
    }
    @Test
    void testMinBelow(){
        clock.ready();
        assertEquals(clock.set(11, -1, 11), ("invalid minute"));
    }
    @Test
    void testSecAbove(){
        clock.ready();
        assertEquals(clock.set(11, 11, 60), ("invalid seconds"));
    }
    @Test
    void testSecUpper(){
        clock.ready();
        assertEquals(clock.set(11, 11, 59), ("11:11:59"));
    }
    @Test
    void testSecLower(){
        clock.ready();
        assertEquals(clock.set(11, 11, 0), ("11:11:00"));
    }
    @Test
    void testSecBelow(){
        clock.ready();
        assertEquals(clock.set(11, 11, -1), ("invalid seconds"));
    }

    /**
     * Test cases for each boundary in the Date object
     */
    @Test
    void testYearAbove(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(5001,12,12), ("invalid year"));
    }
    @Test
    void testYearUpper(){
     clock.changeMode();
     clock.ready();
     assertEquals(clock.set(5000,12,12), ("5000-12-12"));
    }
    @Test
    void testYearLower(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(0,12,12), ("0-12-12"));
    }
    @Test
    void testYearBelow(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(-1,12,12), ("invalid year"));
    }
    @Test
    void testMonthAbove() {
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018, 13, 12), ("invalid month"));
    }
    @Test
    void testMonthUpper(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018,12,12), ("2018-12-12"));
    }
    @Test
    void testMonthLower(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018, 1, 12), ("2018-1-12"));
    }
    @Test
    void testMonthBelow(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018, 0, 12), ("invalid month"));
    }
    @Test
    void testDayAbove(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018,12,32), ("invalid day"));
    }
    @Test
    void testDayUpper(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018,12,31), ("2018-12-31"));
    }
    @Test
    void testDayLower(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018,12,1), ("2018-12-1"));
    }
    @Test
    void testDayBelow(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(2018,12,0), ("invalid day"));
    }
}