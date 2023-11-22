public class AstroDates {
    private int year;
    private int month;
    private int integerDays;
    private double decimalDays;
    private int hour;
    private int minutes;
    private double seconds;
    private final double JULIAN_DAY = 1582 + 10.0 / 12 + 15 / 365.25;
    public AstroDates(int year, int month, double decimalDays){
        this.year = year;
        this.month = month;
        this.decimalDays = decimalDays;
    }

    public AstroDates(int year, int month, int integerDays, int hour, int minutes, int seconds) {
        this.year = year;
        this.month = month;
        this.decimalDays = convertIntegerDate(integerDays,hour,minutes,seconds);
    }

    public double convertIntegerDate(int integerDays, int hour,int minutes, int seconds){
        return 1.0 * integerDays + hour / 24.0 + minutes / 24.0 / 60.0 + seconds / 24.0 / 60.0 / 60.0;
    }

    public double julianDays() {
        int year = this.year;
        int month = this.month;
        double days = this.decimalDays;
        if (month == 1 || month == 2) {
            year -= 1;
            month += 12;
        }
        int A = year / 100;
        int B;
        if(this.year + (double) this.month / 12 + this.decimalDays / 365.25 < JULIAN_DAY) {
            B = 0;
        }
        else {
            B = 2 - A + (A / 4);
        }
        return (int) (365.25 * (year + 4716)) + (int) (30.6001 * (month + 1)) + days + B - 1524.5;
    }
    public double modifiedJulianDays() {
        return this.julianDays() - 2400000.5;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getDecimalDays() {
        return decimalDays;
    }

    public void setDecimalDays(double decimalDays) {
        this.decimalDays = decimalDays;
    }
}
