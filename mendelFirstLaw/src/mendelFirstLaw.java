import java.math.RoundingMode;
import java.text.DecimalFormat;

public class mendelFirstLaw {
    public static double caseProb(int k, int m, int n) {
        int t = k + m + n;
        double c = t * (t - 1) / 2.0;
        double prob = 1 - (n * (n - 1) / 2 + 0.25 * m * (m - 1) / 2 + m * n * 0.5) / c;
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.FLOOR);
        String result = df.format(prob);
        double output = Double.parseDouble(result);
        return output;
    }

    public static void main(String[] args) {
        int k = 30, m = 23, n = 18;
        double result = caseProb(k, m, n);
        System.out.println(result);
    }
}
