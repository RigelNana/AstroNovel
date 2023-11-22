public interface TimeCalculations {


    double getDaysPassed(double julian);
    double getDaysPassed(AstroDates astroDates);
    double getDaysPassed(JulianDays julianDays);
    void timePlus(double julian);
    void timePlus(AstroDates astroDates);
    void timePlus(JulianDays julianDays);
}
