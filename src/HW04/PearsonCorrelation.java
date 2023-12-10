package HW04;

public class PearsonCorrelation {

    public static double correlation(double[] first, double[] second){

        double sx = 0.0;
        double sy = 0.0;
        double sxx = 0.0;
        double syy = 0.0;
        double sxy = 0.0;

        int firstLength = first.length;

        for (int i = 0; i < firstLength; ++i) {
            double x = first[i];
            double y = second[i];

            sx += x;
            sy += y;
            sxx += x * x;
            syy += y * y;
            sxy += x * y;
        }
        /**
         * Found covariation.
         */
        double covariation = sxy / firstLength - sx * sy / firstLength / firstLength;
        /**
         * To found standart error of x.
         */
        double sigmax = Math.sqrt(sxx / firstLength - sx * sx / firstLength / firstLength);
        /**
         * To found standart error of y.
         */
        double sigmay = Math.sqrt(syy / firstLength - sy * sy / firstLength / firstLength);

        /**
         * Found correlation (it is normalised covariation).
         */

        return covariation / sigmax / sigmay;
    }

}
