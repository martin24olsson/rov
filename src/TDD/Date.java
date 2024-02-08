package TDD;

public class Date {
    private int theYear = 2000;
    private int theMonth = 01;
    private int theDay = 01;

    protected void dateSet(int year, int month, int day) {
        this.theYear = year;
        this.theMonth = month;
        this.theDay = day;
    }

    protected String showDate() {
        return String.format("%d-%d-%d", theYear, theMonth, theDay);
    }
}

