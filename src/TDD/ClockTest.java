package TDD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static TDD.State.*;
import static junit.framework.TestCase.assertEquals;

class ClockTest {
    private Clock clock;

    @BeforeEach
    public void before() {
        clock = new Clock();
    }

    //**
        // Test "each state transition test". Testing the valid transitions
    //@Test
    /*void stateTransitionTest() {
        //Default state is DisplayTime
        assertEquals(clock.changeMode(), ("2017-12-01"));
        //Ready to change date
        assertEquals(clock.ready(), ("ChangeDate"));
        //Input new date
        assertEquals(clock.set(1, 2, 3), ("DisplayDate"));
        //Change back to time
        assertEquals(clock.changeMode(), ("DisplayTime"));
        //Go ahead Ready to change time
        assertEquals(clock.ready(), ("ChangeTime"));
        //Input new time
        assertEquals(clock.set(1, 2, 3), ("DisplayTime"));
    }

     */
    @Test
    public void testStateTransitionChangeMode() {
        //Default state is DisplayTime
        clock.changeMode(); // Switch to DisplayDate
        assertEquals("2000-1-1", clock.changeMode());
    }
    @Test
    public void testStateTransitionReady() {
        //Ready to change date
        assertEquals("00:00:00", clock.ready());
    }
    @Test
    public void testStateTransitionSetDate() {
        //Input new date
        clock.changeMode(); // Switch to DisplayDate
        clock.ready(); // Verify the state
        assertEquals("2018-12-12", clock.set(2018, 12, 12));
    }
    @Test
    public void testStateTransitionBackToTime() {
        //Change back to time
        clock.changeMode(); // Switch to DisplayDate
        clock.changeMode();
        //clock.ready(); // Verify the state
        //clock.set(1, 2, 3); // Set new date
        // Switch to DisplayTime
        assertEquals("00:00:00", clock.changeMode());
    }
    @Test
    public void testStateTransitionChangeTime() {
        //Go ahead Ready to change time
        clock.changeMode(); // Switch to DisplayDate
        clock.ready(); // Verify the state
        clock.set(2018, 12, 12); // Set new date
        clock.changeMode(); // Switch to DisplayTime
        //Input new time
        assertEquals("00:00:00", clock.ready());
    }


    /**
     * Tests below are for the six illegal transitions, 1&2 from DisplayX to SetX,
     * 3&4 from ChangeX to ReadyX, and 5&6 from ChangeX to DisplayX
     */
    @Test
    void illegal_DisplayTime_ChangeDate() {
        assertEquals(clock.set(2010, 12, 12), ("Date change failed"));
    }
    @Test
    void illegal_DisplayDate_ChangeTime() {
        clock.changeMode();
        assertEquals(clock.set(12, 12, 12), ("Time change failed"));
    }
    @Test
    void illegal_ChangeTwiceTime() {
        clock.ready();
        assertEquals(clock.ready(), ("Already in change time mode"));
    }
    @Test
    void illegal_ChangeTwiceDate() {
        clock.changeMode();
        clock.ready();
        assertEquals(clock.ready(), ("Already in change date mode"));
    }
    @Test
    void illegal_ChangeMode_Time() {
        clock.ready();
        assertEquals(clock.changeMode(), ("change mode not accessible from change time"));
    }
    @Test
    void illegal_ChangeMode_Date() {
        clock.changeMode();
        clock.ready();
        assertEquals(clock.changeMode(), ("change mode not accessible from change date"));
    }





    //Finally, "test cases for each boundary in the Time and Date object"
    //BVA TESTER 24 st

    @Test
    void testTimeValues() {
        //Normal time value
        //clock.setState(ChangeTime);
        assertEquals(clock.set(8, 8, 8), ("DisplayTime"));
        //Out of range time values
        //Boundaries are to be found in the clock class's method set()
        //clock.setState(ChangeTime);
        assertEquals(clock.set(24, 8, 8), ("illegal"));
        //clock.setState(ChangeTime);
        assertEquals(clock.set(8, -1, 8), ("illegal"));
        //clock.setState(ChangeTime);
        assertEquals(clock.set(8, 8, 60), ("illegal"));
    }

    @Test
    void testDateValues() {
        //Normal date value
        //clock.setState(ChangeDate);
        assertEquals(clock.set(8, 8, 8), ("2017-01"));
        //Out of range date values
        //Boundaries are to be found in the clock class's method set()
        //clock.setState(ChangeDate);
        //assertEquals(clock.set(8000, 8, 8), (illegal));
        //clock.setState(ChangeDate);
        //assertEquals(clock.set(8, -1, 8), (illegal));
        //clock.setState(ChangeDate);
        //assertEquals(clock.set(8, 8, 32), (illegal));
    }
    @Test
    void testDateBelow(){
     clock.changeMode();
     clock.ready();
     assertEquals(clock.set(4999,12,12), ("2018-12-12"));
    }
    @Test
    void testDateAbove(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(5000,12,12), ("2018-12-12"));
    }
    @Test
    void testYearAbove(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(0,12,12), ("Success date change0-12-12"));
    }
    @Test
    void testYearBelow(){
        clock.changeMode();
        clock.ready();
        assertEquals(clock.set(-1,12,12), ("invalid year"));
    }

}