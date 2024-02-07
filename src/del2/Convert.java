package del2;

import java.text.DecimalFormat;

public class Convert {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#################");

    public String toDegrees(int deg, int min, int s) {
        double nbr = deg + (min / 60.0) + (s / 3600.0);
        return DECIMAL_FORMAT.format(nbr);
    }

    public static String toDMS(String str){
        double dd = Double.parseDouble(str);

        int d = (int) dd; //d is decimal and dd is decimal degrees
        double min = (dd-d) * 60;
        double minRoundedDouble = (int) min;
        double sec = (dd-d-(minRoundedDouble/60)) * 3600;

        int minRounded = (int) min;
        int secRounded = (int) sec;

        String output = d + " " + minRounded +" "  + secRounded;
        return output;
    }
}
