import java.io.BufferedReader;
import java.io.FileReader;

public class sharedMotif {

    private static String commonSubstring(String[] input) {
        int inputLength = input.length;
        String s = input[0];
        int len = s.length();
        String output = "";
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String temp = s.substring(i, j);
                int k;
                for (k = 1; k < inputLength; k++) {
                    if (!input[k].contains(temp))
                        break;
                }
                if (k == inputLength && output.length() < temp.length())
                    output = temp;
            }
        }
        return output;
    }

    private static String[] convertData(String input) {
        String newInput = input.replaceAll("\\s", "");
        newInput = newInput.replaceAll(">Rosalind_", ",");
        newInput = newInput.replaceAll("[0-9]", "");
        int length = newInput.length();
        newInput = newInput.substring(1,length);
        return newInput.split(",");
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\sharedMotif\\data\\data.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        br.close();
        String[] data = convertData(everything);
        String answer = commonSubstring(data);
        System.out.println(answer);
    }
}
