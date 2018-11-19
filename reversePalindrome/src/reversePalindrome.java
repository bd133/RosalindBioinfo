import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;

public class reversePalindrome {

    public static String data;
    public static Hashtable<String, Pair<Integer>> result;
    public static int[][] ordered;

    public static void orderBy() {
        ordered = new int[result.size()][2];
        int k = 0;
        for (Pair<Integer> p : result.values()) {
            ordered[k][0] = p.h;
            ordered[k][1] = p.t;
            k++;
        }
        print2dArray(ordered);
    }

    public static void palindrome() {
        result = new Hashtable<>();
        for (int i = 4; i < 13; i++) {
            for (int j = 0; j < data.length() - i + 1; j++) {
                Pair<Integer> temp1 = new Pair<>();
                String temp2 = data.substring(j, j + i - 1);
                if (reverseCompliment(temp2)) {
                    temp1.add(j, temp2.length());
                    if (result.get(temp2) == null)
                        result.put(temp2, temp1);
                }
            }
        }

    }

    public static void print2dArray(int[][] input) {
        String output = Integer.toString(input[0][0]);
        for (int i = 1; i < input[0].length; i++)
            output += " " + input[0][i];
        for (int j = 1; j < input.length; j++) {
            String temp = Integer.toString(input[j][0]);
            for (int k = 1; k < input[0].length; k++)
                temp += " " + input[j][k];
            output += "\n" + temp;
        }
        System.out.println(output);
    }

    public static boolean reverseCompliment(String input) {
        String reverse = "";
        for (int i = input.length() - 1; i >= 0; i--)
            reverse += input.charAt(i);
        String output = compliment(reverse);
        if (output.equals(input))
            return true;
        return false;
    }

    public static String compliment(String input) {
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'A')
                output += 'T';
            else if (input.charAt(i) == 'C')
                output += 'G';
            else if (input.charAt(i) == 'G')
                output += 'C';
            else
                output += 'A';
        }
        return output;
    }

    public static void craftData(String input) {
        String newInput = input.replaceAll("\\s", ",");
        newInput = newInput.replaceAll(",,", ",");
        newInput = newInput.replaceAll(">Rosalind_", "");
        newInput = newInput.substring(5);
        int temp1 = newInput.length() - 1;
        newInput = newInput.substring(0, temp1);
        newInput = newInput.replaceAll(",", "");
        data = newInput;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\reversePalindrome\\data\\data.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        br.close();
        craftData(everything);
        palindrome();
        orderBy();
    }
}
