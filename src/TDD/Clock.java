package TDD;

public class Clock {
    private Time theTime = new Time();
    private Date theDate = new Date();
    private State state = State.DisplayTime;

    public String changeMode(){
        switch (state) {
            case DisplayTime:
                state = State.DisplayDate;
                return theTime.showTime();
            case DisplayDate:
                state = State.DisplayTime;
                return theDate.showDate();
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
                return theTime.showTime();
            case DisplayDate:
                state = State.ChangeDate;
                return theDate.showDate();
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
            case ChangeTime:
                state = State.DisplayTime;
                String str3 = theTime.timeSet(p1, p2, p3);
                return str3;
            case ChangeDate:
                state = State.DisplayDate;
                String str=theDate.dateSet(p1, p2, p3);
                return str;
            case DisplayTime:
                return "Date change failed";
            case DisplayDate:
                return "Time change failed";
            default:
                return null;
        }
    }


}
