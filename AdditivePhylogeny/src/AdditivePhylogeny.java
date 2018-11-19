import java.io.BufferedReader;
import java.io.FileReader;

public class AdditivePhylogeny {


    public static int N;
    public static int[][] D;

    public static void addPhy(int n) {
        if (n == 2) {
            System.out.println("T");
        }
        int limbLength = limb_length(N, D);
        for (int j = 1; j < n - 1; j++) {
            D[j][n] -= limbLength;
            D[n][j] = D[j][n];
        }
        int x = D[i, n];
        // remove.
        addPhy(n - 1);
    }

    public static int limb_length(int n, int[][] d) {
        int i = n % n;
        int k = (n + 1) % n;
        double min = (d[i][n - 1] + d[n - 1][k] - d[i][k]) / 2;
        while (k < n) {
            if (i == n - 1 || k == n - 1)
                break;
            double curr = (d[i][n - 1] + d[n - 1][k] - d[i][k]) / 2;
            min = Math.min(min, curr);
            k++;
        }
        return (int) min;
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

    public static void craftData(String input) {
        String newInput = input.replaceAll("\\s", ",");
        newInput = newInput.replaceAll(",,", ",");
        int temp1 = newInput.length() - 1;
        newInput = newInput.substring(0, temp1);
        String[] temp2 = newInput.split(",");
        N = Integer.parseInt(temp2[0]);
        int temp3 = (int) Math.sqrt(temp2.length - 1);
        D = new int[temp3][temp3];
        int[] temp4 = new int[temp2.length - 1];
        for (int i = 1; i < temp2.length; i++)
            temp4[i - 1] = Integer.parseInt(temp2[i]);
        for (int j = 0; j < temp3; j++) {
            for (int k = 0; k < temp3; k++)
                D[j][k] = temp4[j * temp3 + k];
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\AdditivePhylogeny\\data\\data.txt"));
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



    }
}
