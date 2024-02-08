package TDD;

public class Time {
        private int theHour = 0;
        private int theMinute = 0;
        private int theSecond = 0;

        protected String timeSet(int hour, int minute, int second) {


            if(hour > 23 || hour < 0 ) {
                return "invalid hour";
            }
            if(minute > 59 || minute < 1) {
                return "invalid minute";
            }
            if(second > 59 || second < 1) {
                return "invalid seconds";
            }
            this.theHour = hour;
            this.theMinute = minute;
            this.theSecond = second;
            return "Success time change" + showTime();
        }

        protected String showTime() {
            return String.format("%02d:%02d:%02d", theHour, theMinute, theSecond);

        }
    }
