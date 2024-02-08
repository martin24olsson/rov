package TDD;

public class Time {
        private int theHour = 0;
        private int theMinute = 0;
        private int theSecond = 0;

        protected void timeSet(int hour, int minute, int second) {
            this.theHour = hour;
            this.theMinute = minute;
            this.theSecond = second;
        }

        protected String showTime() {
            return String.format("%02d:%02d:%02d", theHour, theMinute, theSecond);
        }
    }
