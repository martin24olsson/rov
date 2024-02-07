package TDD;

import org.junit.jupiter.api.Test;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

public class Clock {
    private Time theTime;
    private Date theDate;
    private State state = State.DisplayTime;
    private final String illegal = "illegal";

    public Clock() {}

    public String changeMode(){
        switch (state) {
            case DisplayTime:
                state = State.DisplayDate;
                return state.toString();
            case DisplayDate:
                state = State.DisplayTime;
                return state.toString();
            default:
                return illegal;
        }
    }

    public String ready(){
        switch (state) {
            case DisplayTime:
                state = State.ChangeTime;
                return state.toString();
            case DisplayDate:
                state = State.ChangeDate;
                return state.toString();
            default:
                return illegal;
        }
    }

    public String set(int p1, int p2, int p3){
        switch (state) {
            case ChangeTime:
                if(p1>23 || p1<0 || p2>59 || p2<0 || p3>59 ||p3<0) {
                    return illegal;
                }
                state = State.DisplayTime;
                return state.toString();
            case ChangeDate:
                //Months in java Date class is represented by integers 0 for Januari to 11 for December
                //Days represented from 1 to 31
                if(p1>5000 || p1<-5000 || p2>11 || p2<0 || p3>31 ||p3<1) {
                    return illegal;
                }
                state = State.DisplayDate;
                return state.toString();
            default:
                return illegal;
        }
    }

    //Method for test purposes
    public void setState(State state) {
        this.state = state;
    }
}
