public class Main {
    public static void main(String[] args) {
        AstroDates astroDates = new AstroDates(1910,4,20);
        AstroDates astroDates1 = new AstroDates(1986,2,9);
        AstroDates astroDates2 = new AstroDates(1988,4,22);
        System.out.println(astroDates.getDaysPassed(astroDates1));
        System.out.println(astroDates2.getNthDayOfTheYear());
    }
}