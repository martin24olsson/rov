package TDD;

public class Clock {
    private Time theTime = new Time();
    private Date theDate = new Date();
    private State state = State.DisplayTime;

    public String changeMode(){
        switch (state) {
            case DisplayTime:
                state = State.DisplayDate;
                return theDate.showDate();
            case DisplayDate:
                state = State.DisplayTime;
                return theTime.showTime();
            case ChangeDate:
                return "change mode not accessible from change date";
            case ChangeTime:
                return "change mode not accessible from change time";
        }
        return null;
    }

    public String ready(){
        switch (state) {
            case DisplayTime:
                state = State.ChangeTime;
                return "Give Time";
            case DisplayDate:
                state = State.ChangeDate;
                return "Give Date";
            case ChangeDate:
                return "Already in change date mode";
            case ChangeTime:
                return "Already in change time mode";
            default:
                return null;
        }
    }

    public String set(int p1, int p2, int p3){
        switch (state) {
            case DisplayTime:
                return "Time change failed";
            case DisplayDate:
                return "Date change failed";
            case ChangeTime:
                state = State.DisplayTime;
                return theTime.timeSet(p1, p2, p3);
            case ChangeDate:
                state = State.DisplayDate;
                return theDate.dateSet(p1, p2, p3);
            default:
                return null;
        }
    }


}
