public class AstroDates implements TimeCalculations {
    private int year;
    private int month;
    private double decimalDays;


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
    public AstroDates(JulianDays julianDays){
         AstroDates astroDates = julianDays.JulianDaysToAstroDates();
         this.year = astroDates.getYear();
         this.month = astroDates.getMonth();
         this.decimalDays = astroDates.getDecimalDays();
    }
    public AstroDates(double julianDays){
        JulianDays j = new JulianDays(julianDays);
        AstroDates l = new AstroDates(j);
        this.year = l.getYear();
        this.month = l.getMonth();
        this.decimalDays = l.getDecimalDays();
    }

    public double convertIntegerDate(int integerDays, int hour,int minutes, int seconds){
        return 1.0 * integerDays + hour / 24.0 + minutes / 24.0 / 60.0 + seconds / 24.0 / 60.0 / 60.0;
    }


    public double toJulianDays() {
        int year = this.year;
        int month = this.month;
        double days = this.decimalDays;
        if (month == 1 || month == 2) {
            year -= 1;
            month += 12;
        }
        int A = year / 100;
        int B;
        double JULIAN_DAY = 1582 + 10.0 / 12 + 15 / 365.25;
        if(this.year + (double) this.month / 12 + this.decimalDays / 365.25 < JULIAN_DAY) {
            B = 0;
        }
        else {
            B = 2 - A + (A / 4);
        }
        return (int) (365.25 * (year + 4716)) + (int) (30.6001 * (month + 1)) + days + B - 1524.5;
    }
    public double modifiedJulianDays() {
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

    @Override
    public double getDaysPassed(AstroDates astroDates) {
        return this.toJulianDays() - astroDates.toJulianDays();
    }

    @Override
    public double getDaysPassed(double julian) {
        return this.toJulianDays() - julian;
    }

    @Override
    public double getDaysPassed(JulianDays julianDays) {
        return this.toJulianDays() - julianDays.getJulian();
    }

    @Override
    public void timePlus(double julian) {
        AstroDates newAstroDates = new AstroDates(this.toJulianDays() + julian);
        this.year = newAstroDates.getYear();
        this.month = newAstroDates.getMonth();
        this.decimalDays = newAstroDates.getDecimalDays();
    }

    @Override
    public void timePlus(AstroDates astroDates) {
        AstroDates newAstroDates = new AstroDates(astroDates.toJulianDays() + this.toJulianDays());
        this.year = newAstroDates.getYear();
        this.month = newAstroDates.getMonth();
        this.decimalDays = newAstroDates.getDecimalDays();
    }

    @Override
    public void timePlus(JulianDays julianDays) {
        AstroDates astroDates = new AstroDates(julianDays.getJulian() + this.toJulianDays());


    }
}
