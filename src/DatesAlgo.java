public class DatesAlgo {
    public static AstroDates fromJulianToAstroDates(double julian) {
        julian += 0.5;
        int Z = (int) julian;
        double F = julian - Z;
        int A;
        if(Z < 2299161) {
            A = Z;
        }else {
            int alpha = (int) ((Z - 1867216.25) / 36524.25);
            A = Z + 1 + alpha - alpha / 4;
        }
        int B = A + 1524;
        int C = (int) ((B - 122.1) / 365.25);
        int D = (int) (365.25 * C);
        int E = (int) ((B - D) / 30.6001);
        double day = B - D - (int) (30.6001 * E) + F;
        int month;
        if(E < 14) {
            month = E - 1;
        }else {
            month = E - 13;
        }
        int year;
        if(month > 2) {
            year = C - 4716;
        }else {
            year = C - 4715;
        }
        return new AstroDates(year, month, day);
    }
    public static AstroDates fromModifiedJulianToAstroDates(double modifiedJulian) {
        return fromJulianToAstroDates(modifiedJulian + 2400000.5);
    }
    public static double fromAstroDatesToJulian(AstroDates astroDates) {
        int year = astroDates.getYear();
        int month = astroDates.getMonth();
        double days = astroDates.getDecimalDays();
        if (month == 1 || month == 2) {
            year -= 1;
            month += 12;
        }
        int A = year / 100;
        int B;
        double JULIAN_DAY = 1582 + 10.0 / 12 + 15 / 365.25;
        if(astroDates.getYear() + (double) astroDates.getMonth() / 12 + astroDates.getDecimalDays() / 365.25 < JULIAN_DAY) {
            B = 0;
        }
        else {
            B = 2 - A + (A / 4);
        }
        return (int) (365.25 * (year + 4716)) + (int) (30.6001 * (month + 1)) + days + B - 1524.5;
    }
    public static double fromAstroDatesToModifiedJulian(AstroDates astroDates) {
        return fromAstroDatesToJulian(astroDates) - 2400000.5;
    }
    public static double fromJulianToModifiedJulian(double julian) {
        return julian - 2400000.5;
    }
    public static double fromModifiedJulianToJulian(double modifiedJulian) {
        return modifiedJulian + 2400000.5;
    }
    public static int getNthDayOfTheYear(AstroDates astroDates) {
        int m = astroDates.getMonth();
        int d = (int) astroDates.getDecimalDays();
        int k;
        if (astroDates.isLeapYear()) {
            k = 1;
        } else {
            k = 2;
        }
        return (275 * m / 9) - k * ((m + 9) / 12) + d - 30;
    }
    public static int getNthDayOfTheYear(int year, int month, double day) {
        return getNthDayOfTheYear(new AstroDates(year, month, day));
    }
    public static double twoDatesDifference(AstroDates astroDates1, AstroDates astroDates2) {
        return astroDates1.toJulianDays() - astroDates2.toJulianDays();
    }
    public static double twoDatesDifference(int year1, int month1, double day1, int year2, int month2, double day2) {
        return twoDatesDifference(new AstroDates(year1, month1, day1), new AstroDates(year2, month2, day2));
    }
    public static double twoDatesDifference(double julian1, double julian2) {
        return julian1 - julian2;
    }
    public static AstroTimes meanSiderealTime(AstroDates astroDates) {
        double T = julianCentury(astroDates);
        double theta = 280.46061837 + 360.98564736629*(astroDates.toJulianDays()-2451545.0) + 0.000387933 * T * T - T * T * T/38710000;
        return thetaToHour(theta);
    }
    public static double julianCentury(AstroDates astroDates) {
        return (astroDates.toJulianDays() - 2451545.0) / 36525;
    }
    private static AstroTimes thetaToHour(double theta) {
        if(theta < 0){
            while(theta < 0){
                theta += 360;
            }
        }else{
            while((theta - 360) > 1e-15) {
                theta -= 360;
            }
        }
        int hour = (int)(theta / 15);
        int minute = (int)((theta - hour * 15) * 4);
        double second = ((theta - hour * 15) * 4 - minute) * 60;
        return new AstroTimes(hour, minute, second);
    }


}
