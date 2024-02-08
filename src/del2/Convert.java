package del2;

import java.text.DecimalFormat;

public class Convert {
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.#################");

    public String toDegrees(int deg, int min, int s) {
        if(deg <0 || min<0 || s<0){
            return "illegal";
        }

        double nbr = deg + (min / 60.0) + (s / 3600.0);
        return DECIMAL_FORMAT.format(nbr);  // Format the result using DECIMAL_FORMAT
    }

    public static String toDMS(String str) {
        str = str.replace(',', '.');

        double dd = Double.parseDouble(str);
        DECIMAL_FORMAT.format(dd);

        int d = (int) dd; //d is decimal and dd is decimal degrees
        double min = (dd-d) * 60;
        double minRoundedDouble = (int) min;
        double sec = (dd-d-(minRoundedDouble/60)) * 3600;
        //This is equal to -> double sec = (min - (int) min) * 60;

        int minRounded = (int) min;
        int secRounded = (int) Math.round(sec);

        String output = d + " " + minRounded + " " + secRounded;
        return output;
    }
}
