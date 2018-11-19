import java.util.Hashtable;
import java.io.File;
import java.util.Scanner;
import java.math.BigInteger;

public class protein2mRNA {
    public static Hashtable<Character, Integer> colonChart = new Hashtable<>();

    public static int protein2mrna(String input) {
        genChart();
        BigInteger output = new BigInteger("1");
        int inputL = input.length();
        for (int i = 0; i < inputL; i++) {
            BigInteger temp = new BigInteger(Integer.toString(colonChart.get(input.charAt(i))));
            output = output.multiply(temp);
        }
        BigInteger stopPiece = new BigInteger("3");
        BigInteger modNum = new BigInteger("1000000");
        output = output.multiply(stopPiece);
        output = output.mod(modNum);
        int count = output.intValue();
        return count;
    }

    public static void genChart() {
        colonChart.put('A', 4);
        colonChart.put('C', 2);
        colonChart.put('D', 2);
        colonChart.put('E', 2);
        colonChart.put('F', 2);
        colonChart.put('G', 4);
        colonChart.put('H', 2);
        colonChart.put('I', 3);
        colonChart.put('K', 2);
        colonChart.put('L', 6);
        colonChart.put('M', 1);
        colonChart.put('N', 2);
        colonChart.put('P', 4);
        colonChart.put('Q', 2);
        colonChart.put('R', 6);
        colonChart.put('S', 6);
        colonChart.put('T', 4);
        colonChart.put('V', 4);
        colonChart.put('W', 1);
        colonChart.put('Y', 2);
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\protein2mRNA\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        int answer = protein2mrna(given);
        System.out.println(answer);
    }
}
