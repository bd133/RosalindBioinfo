import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class randomStrings {

    public static String getLogarithm(String dna, double[] input) {
        double[] output = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            double temp = 1;
            for (int j = 0; j < dna.length(); j++) {
                if (dna.charAt(j) == 'A' || dna.charAt(j) == 'T')
                    temp = temp * ((1 - input[i]) / 2);
                if (dna.charAt(j) == 'C' || dna.charAt(j) == 'G')
                    temp = temp * (input[i] / 2);
            }
            DecimalFormat df = new DecimalFormat("##.###");
            String result = df.format(Math.log10(temp));
            double answer = Double.parseDouble(result);
            output[i] = answer;
        }
        String result = Arrays.toString(output);
        result = result.substring(1, result.length() - 1);
        result = result.replaceAll(",", "");
        return result;
    }

    private static String craftString(String input) {
        String newInput = input.replaceAll("\\s", "");
        newInput = newInput.replaceAll("[0-9]", "");
        newInput = newInput.replaceAll("\\.", "");
        return newInput;
    }

    public static double[] craftDigits(String input) {
        String newInput = input.replaceAll("[A-Z]", "");
        int length = newInput.length();
        newInput = newInput.substring(2, length - 2);
        String[] temp = newInput.split("\\s");
        double[] output = Arrays.stream(temp).mapToDouble(Double::parseDouble).toArray();
        return output;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\randomStrings\\data\\data.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        br.close();
        String temp1 = craftString(everything);
        double[] temp2 = craftDigits(everything);
        System.out.println(getLogarithm(temp1, temp2));
    }
}
