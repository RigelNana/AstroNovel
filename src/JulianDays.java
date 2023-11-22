
public class JulianDays implements TimeElapsed{
    private double julian;
    public JulianDays(double julian){
        this.julian = julian;
    }
    public AstroDates JulianDaysToAstroDates(){
        double julian = this.julian;
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
        double d = B - D - (int) (30.6001 * E) + F;
        int m;
        int y;
        if(E < 14){
            m = E - 1;
        }else if(E == 14 || E == 15){
            m = E-13;
        }else{
            m = -1;
        }
        if(m > 2){
            y = C - 4716;
        }else if(m == 1 || m == 2) {
            y = C - 4715;
        }else{
            y = -1;
        }
        return new AstroDates(y,m,d);
    }

    public double getJulian() {
        return julian;
    }

    public void setJulian(double julian) {
        this.julian = julian;
    }

    @Override
    public double getDaysPassed(double julian) {
        return this.getJulian() - julian;
    }

    @Override
    public double getDaysPassed(AstroDates astroDates) {
        return this.getJulian() - astroDates.julianDays();
    }
    @Override
    public double getDaysPassed(JulianDays julianDays){
        return this.getJulian() - julianDays.getJulian();
    }
}
