import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GCContent {

    public static ArrayList<String> TITLE = new ArrayList<>();
    public static ArrayList<String> DATA = new ArrayList<>();

    public static void gcContent() {
        double[] percentage = new double[TITLE.size()];
        for (int i = 0; i < DATA.size(); i++)
            percentage[i] = gcPercentage(DATA.get(i));
        double max = 0.0;
        int k = 0;
        for (int j = 0; j < percentage.length; j++) {
            if (percentage[j] > max) {
                max = percentage[j];
                k++;
            }
        }
        max *= 100;
        System.out.println(TITLE.get(k));
        System.out.println(max);
    }

    public static double gcPercentage(String input) {
        double gcCount = 0;
        double total = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'C' || input.charAt(i) == 'G') {
                gcCount++;
                total++;
            } else
                total++;
        }
        return gcCount / total;
    }

    public static void craftData(String input) {
        String newInput1 = input.replaceAll("\\s", ",");
        String newInput2 = input.replaceAll("\\s", ",");
        newInput1 = newInput1.replaceAll(",,", ",");
        newInput2 = newInput2.replaceAll(",,", ",");
        newInput1 = newInput1.substring(1);
        newInput2 = newInput2.substring(1);
        String[] split1 = newInput1.split(">");
        String[] split2 = newInput2.split(">");
        ArrayList<ArrayList<String>> sp1 = new ArrayList<>();
        ArrayList<String> sp2 = new ArrayList<>();
        for (int i = 0; i < split1.length; i++) {
            ArrayList<String> temp1 = new ArrayList<>();
            int indexTemp1 = split1[i].length() - 1;
            int indexTemp2 = split2[i].length() - 1;
            split1[i] = split1[i].substring(0, indexTemp1);
            split2[i] = split2[i].substring(0, indexTemp2);
            String[] tempList1 = split1[i].split(",");
            String[] tempList2 = split2[i].split(",");
            for (int j = 1; j < tempList1.length; j++)
                temp1.add(j - 1, tempList1[j]);
            sp1.add(i, temp1);
            sp2.add(i, tempList2[0]);
        }
        TITLE = sp2;
        for (int k = 0; k < sp1.size(); k++) {
            String temp = "";
            for (int m = 0; m < sp1.get(k).size(); m++)
                temp += sp1.get(k).get(m);
            DATA.add(k, temp);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\GCContent\\data\\data.txt"));
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
        gcContent();
    }
}
