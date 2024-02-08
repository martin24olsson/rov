package TDD;

public class Date {
    private int theYear = 2000;
    private int theMonth = 01;
    private int theDay = 01;

    protected String dateSet(int year, int month, int day) {
        if(year > 5000 || year < 0 ) {
            return "invalid year";
        }
        if(month > 12 || month < 1) {
            return "invalid month";
        }
        if(day > 31 || day < 1) {
            return "invalid day";
        }
        this.theYear = year;
        this.theMonth = month;
        this.theDay = day;

        return "Success date change" + showDate();
    }

    protected String showDate() {
        return String.format("%d-%d-%d", theYear, theMonth, theDay);
    }
}

