package TDD;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static TDD.State.*;
import static junit.framework.TestCase.assertEquals;

class ClockTest {
    @Before
    void stateTransitionTest() {
    private Clock clock = new Clock();
    private final String illegal = "illegal";

    //Test "each state transition test". Testing the valid transitions
    @Test
    void stateTransitionTest() {
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

    /**
     * Tests below are for the six illegal transitions, 1&2 from DisplayX to SetX,
     * 3&4 from ChangeX to ReadyX, and 5&6 from ChangeX to DisplayX
     */
    @Test
    void illegal1() {
        clock.setState(State.DisplayTime);
        assertEquals(clock.set(1, 2, 3), (illegal));
    }
    @Test
    void illegal2() {
        clock.setState(DisplayDate);
        assertEquals(clock.set(1, 2, 3), (illegal));
    }
    @Test
    void illegal3() {
        clock.setState(State.ChangeTime);
        assertEquals(clock.ready(), (illegal));
    }
    @Test
    void illegal4() {
        clock.setState(State.ChangeDate);
        assertEquals(clock.ready(), (illegal));
    }
    @Test
    void illegal5() {
        clock.setState(State.ChangeTime);
        assertEquals(clock.changeMode(), (illegal));
    }
    @Test
    void illegal6() {
        clock.setState(State.ChangeDate);
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