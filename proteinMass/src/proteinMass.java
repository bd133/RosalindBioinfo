import java.util.Hashtable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.io.File;
import java.util.Scanner;

public class proteinMass {
    public static Hashtable<Character, Double> proteinChart = new Hashtable<>();
    public static double calcMass(String input) {
        genChart();
        int inputL = input.length();
        double count = 0.0;
        for (int i = 0; i < inputL; i++)
            count += proteinChart.get(input.charAt(i));
        DecimalFormat df = new DecimalFormat("#####.###");
        df.setRoundingMode(RoundingMode.FLOOR);
        String result = df.format(count);
        double output = Double.parseDouble(result);
        return output;
    }
    public static void genChart() {
        proteinChart.put('A', 71.03711);
        proteinChart.put('C', 103.00919);
        proteinChart.put('D', 115.02694);
        proteinChart.put('E', 129.04259);
        proteinChart.put('F', 147.06841);
        proteinChart.put('G', 57.02146);
        proteinChart.put('H', 137.05891);
        proteinChart.put('I', 113.08406);
        proteinChart.put('K', 128.09496);
        proteinChart.put('L', 113.08406);
        proteinChart.put('M', 131.04049);
        proteinChart.put('N', 114.04293);
        proteinChart.put('P', 97.05276);
        proteinChart.put('Q', 128.05858);
        proteinChart.put('R', 156.10111);
        proteinChart.put('S', 87.03203);
        proteinChart.put('T', 101.04768);
        proteinChart.put('V', 99.06841);
        proteinChart.put('W', 186.07931);
        proteinChart.put('Y', 163.06333);
    }
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\proteinMass\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        double answer = calcMass(given);
        System.out.println(answer);
    }
}