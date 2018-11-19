import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class AH_INS {

    public static ArrayList<Integer> DATA = new ArrayList<>();
    public static Integer N;

    public static int numSwaps() {
        int k, val = 0;
        for (int i = 2; i < N; i++) {
            k = i;
            while (k > 1 && DATA.get(k) < DATA.get(k - 1)) {
                swap(DATA.get(k), DATA.get(k - 1));
                val++;
                k--;
            }
        }
        return val;
    }

    public static void swap(int A, int B) {
        int index1 = DATA.indexOf(A), index2 = DATA.indexOf(B);
        Collections.swap(DATA, index1, index2);
    }

    public static void craftData(String input) {
        String newInput = input.replaceAll("\\s", ",");
        newInput = newInput.replaceAll(",,", ",");
        int index = newInput.length() - 1;
        newInput = newInput.substring(0, index);
        String[] temp1 = newInput.split(",");
        String tempN = temp1[0];
        N = Integer.parseInt(tempN);
        for (int i = 1; i < temp1.length; i++)
            DATA.add(i - 1, Integer.parseInt(temp1[i]));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\AH_INS\\data\\data.txt"));
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
        System.out.println(numSwaps());
    }
}
