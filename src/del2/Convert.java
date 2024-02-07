package del2;

import java.text.DecimalFormat;

public class Convert {

    public static String toDegrees(int deg, int min, int s) {
        double nbr = deg + (min / 60.0) + (s / 3600.0);

        // Use Double.toString() to convert the double value to a string
        return Double.toString(nbr) + "°";
    }

    public static String toDMS(String s){
        double nbr = Double.parseDouble(s);

        int d = (int) nbr;
        double min = ((nbr-d) * 60);
        double sec = (nbr-d-(min/60) * 3600);

        int m2 = (int) min;
        int s2 = (int) sec;

        return d + "° " + m2 +"' "  + s2 +"''";

    }
}
