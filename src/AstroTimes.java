import java.time.LocalTime;

public class AstroTimes {
    private int hour;
    private int minutes;
    private double seconds;

    public AstroTimes(int hour, int minutes, double seconds) {
        this.hour = hour;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    public AstroTimes(LocalTime time){
        this.hour = time.getHour();
        this.minutes = time.getMinute();
        this.seconds = time.getSecond();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public double getSeconds() {
        return seconds;
    }

    public void setSeconds(double seconds) {
        this.seconds = seconds;
    }
}
