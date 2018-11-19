import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class lengthLex {

    public static String[] initial;
    public static int N;
    public static ArrayList<String> result;

    public static void orderingString() {
        result = new ArrayList<>();
        String given = "";
        for (int i = 0; i < initial.length; i++)
            given += initial[i];
        ArrayList<String> output = new ArrayList<>();
        orderingHelper("", given, N + 1, output);
        result = output;
    }

    public static void orderingHelper(String prefix, String dictionary, int k, ArrayList<String> list) {
        if (k != 0) {
            if (!prefix.equals(""))
                list.add(prefix);
            for (int i = 0; i < dictionary.length(); i++)
                orderingHelper(prefix + dictionary.charAt(i), dictionary, k - 1, list);
        }
    }

    public static void print1dArrayList(ArrayList<String> input) throws Exception {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        System.out.println(input.get(0));
        for (int i = 1; i < input.size(); i++)
            System.out.println(input.get(i));
    }

    public static void craftData(String input) {
        String newInput = input.replaceAll("\\s", ",");
        int temp1 = newInput.length() - 2;
        newInput = newInput.substring(0, temp1);
        newInput = newInput.replaceAll(",,", ",");
        String[] temp2 = newInput.split(",");
        int temp3 = temp2.length;
        N = Integer.parseInt(temp2[temp3 - 1]);
        String[] temp4 = new String[temp3 - 1];
        for (int i = 0; i < temp4.length; i++)
            temp4[i] = temp2[i];
        initial = new String[temp4.length];
        initial = temp4;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\lengthLex\\data\\data.txt"));
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
        orderingString();
        print1dArrayList(result);
    }
}
