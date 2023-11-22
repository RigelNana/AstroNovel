import java.time.LocalDateTime;

public class AstroDates {
    private int year;
    private int month;
    private double decimalDays;


    public AstroDates(int year, int month, double decimalDays){
        this.year = year;
        this.month = month;
        this.decimalDays = decimalDays;
    }
    public AstroDates(LocalDateTime dateTime) {
        this.year = dateTime.getYear();
        this.month = dateTime.getMonthValue();
        this.decimalDays = dateTime.getDayOfMonth() + dateTime.getHour() / 24.0 + dateTime.getMinute() / 24.0 / 60.0 + dateTime.getSecond() / 24.0 / 60.0 / 60.0;
    }

    public AstroDates(int year, int month, int integerDays, int hour, int minutes, double seconds) {
        this.year = year;
        this.month = month;
        this.decimalDays = convertIntegerDate(integerDays,hour,minutes,seconds);
    }

    private double convertIntegerDate(int integerDays, int hour,int minutes, double seconds){
        return 1.0 * integerDays + hour / 24.0 + minutes / 24.0 / 60.0 + seconds / 24.0 / 60.0 / 60.0;
    }


    public double toJulianDays() {
        return DatesAlgo.fromAstroDatesToJulian(this);
    }

    public double toModifiedJulianDays() {
        return this.toJulianDays() - 2400000.5;
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

    public int getWeekOrder() {
        return (int) ((this.toJulianDays() + 1.5) % 7);
    }
    public int getNthDayOfTheYear() {
        return DatesAlgo.getNthDayOfTheYear(this);
    }
    public boolean isLeapYear() {
        return (this.year % 4 == 0 && this.year % 100 != 0) || this.year % 400 == 0;
    }


    public double getDaysPassed(AstroDates astroDates) {
        return  (this.toJulianDays() - astroDates.toJulianDays());
    }
    public double getDaysPassed(double julianDays) {
        return  (this.toJulianDays() - julianDays);
    }
    public double julianCentury() {
        return (this.toJulianDays() - 2451545.0) / 36525;
    }

}
