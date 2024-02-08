package TDD;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static TDD.State.*;
import static junit.framework.TestCase.assertEquals;

class ClockTest {
    private Clock clock;

    @Before
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
        assertEquals("2000-01-01", clock.changeMode());
    }
    @Test
    public void testStateTransitionReady() {
        //Ready to change date
        clock.changeMode(); // Switch to DisplayDate
        assertEquals("ChangeDate", clock.ready());
    }
    @Test
    public void testStateTransitionSetDate() {
        //Input new date
        clock.changeMode(); // Switch to DisplayDate
        clock.ready(); // Verify the state
        assertEquals("DisplayDate", clock.set(1, 2, 3));
    }
    @Test
    public void testStateTransitionBackToTime() {
        //Change back to time
        clock.changeMode(); // Switch to DisplayDate
        clock.changeMode(); // Switch to DisplayDate

        //clock.ready(); // Verify the state
        //clock.set(1, 2, 3); // Set new date
        // Switch to DisplayTime
        assertEquals("00-00-00", clock.changeMode());
    }
    @Test
    public void testStateTransitionChangeTime() {
        //Go ahead Ready to change time
        clock.changeMode(); // Switch to DisplayDate
        clock.ready(); // Verify the state
        clock.set(1, 2, 3); // Set new date
        clock.changeMode(); // Switch to DisplayTime
        //Input new time
        assertEquals("00-00-00", clock.ready());
    }


    /**
     * Tests below are for the six illegal transitions, 1&2 from DisplayX to SetX,
     * 3&4 from ChangeX to ReadyX, and 5&6 from ChangeX to DisplayX
     */
    @Test
    void illegal1() {
        
        assertEquals(clock.set(1, 2, 3), (""));
    }
    @Test
    void illegal2() {
        assertEquals(clock.set(1, 2, 3), (illegal));
    }
    @Test
    void illegal3() {
        assertEquals(clock.ready(), (illegal));
    }
    @Test
    void illegal4() {
        assertEquals(clock.ready(), (illegal));
    }
    @Test
    void illegal5() {
        assertEquals(clock.changeMode(), (illegal));
    }
    @Test
    void illegal6() {
        assertEquals(clock.changeMode(), (illegal));
    }

    //Finally, "test cases for each boundary in the Time and Date object"
    @Test
    void testTimeValues() {
        //Normal time value
        clock.setState(ChangeTime);
        assertEquals(clock.set(8, 8, 8), ("DisplayTime"));
        //Out of range time values
        //Boundaries are to be found in the clock class's method set()
        clock.setState(ChangeTime);
        assertEquals(clock.set(24, 8, 8), (illegal));
        clock.setState(ChangeTime);
        assertEquals(clock.set(8, -1, 8), (illegal));
        clock.setState(ChangeTime);
        assertEquals(clock.set(8, 8, 60), (illegal));
    }

    @Test
    void testDateValues() {
        //Normal date value
        clock.setState(ChangeDate);
        assertEquals(clock.set(8, 8, 8), ("2017-01"));
        //Out of range date values
        //Boundaries are to be found in the clock class's method set()
        clock.setState(ChangeDate);
        assertEquals(clock.set(8000, 8, 8), (illegal));
        clock.setState(ChangeDate);
        assertEquals(clock.set(8, -1, 8), (illegal));
        clock.setState(ChangeDate);
        assertEquals(clock.set(8, 8, 32), (illegal));
    }
}