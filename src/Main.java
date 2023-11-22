public class Main {
    public static void main(String[] args) {
        final double LONGITUDE = 126.65;

        //AstroDates astroDates = new AstroDates(LocalDateTime.now(ZoneId.of("UT")));
        AstroDates astroDates = new AstroDates(2023,11,22+16.0 / 24);
        System.out.println(DatesAlgo.fromAstroDatesToJulian(astroDates));


        System.out.println(DatesAlgo.meanLocalUTSiderealTime(astroDates,LONGITUDE).getHour() + " " + DatesAlgo.meanLocalUTSiderealTime(astroDates,LONGITUDE).getMinutes() + " " + DatesAlgo.meanLocalUTSiderealTime(astroDates,LONGITUDE).getSeconds());

    }
}