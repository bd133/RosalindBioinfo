import java.io.File;
import java.util.Scanner;

public class DNAintoRNA {
    public static String transcribeDNA(String input) {
        String answer = "";
        int inputLength = input.length();
        for (int i = 0; i < inputLength; i++) {
            if (input.charAt(i) == 'T')
                answer = answer + 'U';
            else
                answer = answer + input.charAt(i);
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\DNAintoRNA\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        String result = transcribeDNA(given);
        System.out.println(result);

        String testSequence = "ATGGTCTACATAGCTGACAAACAGCACGTAGCATCTCGAGAGGCATATGGTCACATGTTCAAAGTTTGCGCCTAG";
        System.out.println(transcribeDNA(testSequence));
    }
}
