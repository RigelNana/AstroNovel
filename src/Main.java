public class Main {
    public static void main(String[] args) {
        AstroDates e = new AstroDates(-4712,1,1.5);
        System.out.println(e.toJulianDays());
        JulianDays j = new JulianDays(2436116.31);
        System.out.println(j.JulianDaysToAstroDates().getDecimalDays());
    }
}