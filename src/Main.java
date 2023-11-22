import java.time.LocalDateTime;
import java.time.ZoneId;

public class Main {
    public static void main(String[] args) {

        AstroDates astroDates = new AstroDates(LocalDateTime.now(ZoneId.of("UT")));
        System.out.println(DatesAlgo.fromAstroDatesToJulian(astroDates));
        System.out.println(DatesAlgo.meanUTSiderealTime(astroDates).getHour() + " " + DatesAlgo.meanUTSiderealTime(astroDates).getMinutes() + " " + DatesAlgo.meanUTSiderealTime(astroDates).getSeconds());

    }
}