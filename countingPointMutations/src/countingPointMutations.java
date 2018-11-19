import java.io.File;
import java.util.Scanner;

public class countingPointMutations {
    public static int hammingDis(String input) {
        int strLength = input.length() / 2, distance = 0;
        String firstHalf = input.substring(0, strLength);
        String secondHalf = input.substring(strLength, input.length());
        for (int i = 0; i < strLength; i++) {
            if (firstHalf.charAt(i) != secondHalf.charAt(i))
                distance += 1;
        }
        return distance;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\countingPointMutations\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        int result = hammingDis(given);
        System.out.println(result);
    }
}