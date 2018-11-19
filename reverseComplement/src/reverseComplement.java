import java.io.File;
import java.util.Scanner;

public class reverseComplement {
    public static String reverse(String input) {
        String temp = "", answer = "";
        int inputLength = input.length(), errorCount = 0;
        for (int i = 0; i < inputLength; i++) {
            if (input.charAt(i) == 'A')
                temp = temp + 'T';
            else if (input.charAt(i) == 'C')
                temp = temp + 'G';
            else if (input.charAt(i) == 'G')
                temp = temp + 'C';
            else if (input.charAt(i) == 'T')
                temp = temp + 'A';
            else
                errorCount += 1;
        }
        for (int j = temp.length() - 1; j >= 0; j--)
            answer = answer + temp.charAt(j);
        return answer;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\reverseComplement\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        String result = reverse(given);
        System.out.println(result);
    }
}