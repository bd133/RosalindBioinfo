import java.io.File;
import java.util.Scanner;

public class countingDNANucleotides {
    public static String count(String input) {
        String answer = "";
        int inputLength = input.length(), countA = 0, countC = 0, countG = 0, countT = 0, errorCount = 0;
        for (int i = 0; i < inputLength; i++) {
            if (input.charAt(i) == 'A')
                countA += 1;
            else if (input.charAt(i) == 'C')
                countC += 1;
            else if (input.charAt(i) == 'G')
                countG += 1;
            else if (input.charAt(i) == 'T')
                countT += 1;
            else
                errorCount += 1;
        }
        answer = answer + countA + " " + countC + " " + countG + " " + countT;
        return answer;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\countingDNANucleotides\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        String result = count(given);
        System.out.println(result);
    }
}