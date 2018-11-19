import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class consensusProfile {

    public static void getAnswer(ArrayList<String> data) {
        System.out.println(getProfile(data));
        printMatrix(buildMatrix(data));
    }

    public static String getProfile(ArrayList<String> input) {
        int[][] profileMatrix = buildMatrix(input);
        String consensusDNA = "";
        char[] base = {'A', 'C', 'G', 'T'};
        int row = profileMatrix.length, col = profileMatrix[0].length;
        for (int i = 0; i < col; i++) {
            int index = 0;
            for (int j = 1; j < row; j++) {
                if (profileMatrix[j][i] > profileMatrix[index][i]) {
                    index = j;
                }
            }
            consensusDNA = consensusDNA + base[index];
        }
        return consensusDNA;
    }

    public static int[][] buildMatrix(ArrayList<String> data) {
        int len = data.get(0).length();
        int[][] output = new int[4][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < data.size(); j++) {
                switch (data.get(j).charAt(i)) {
                    case 'A' : output[0][i]++; break;
                    case 'C' : output[1][i]++; break;
                    case 'G' : output[2][i]++; break;
                    case 'T' : output[3][i]++; break;
                }
            }
        }
        return output;
    }

    public static void printMatrix(int[][] input) {
        int row = input.length;
        int col = input[0].length;
        char[] base = {'A', 'C', 'G', 'T'};
        for (int i = 0; i < row; i++) {
            System.out.print(base[i] + ":");
            for (int j = 0; j < col; j++)
                System.out.print(" " + input[i][j]);
            System.out.println();
        }
        System.out.println();
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
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\consensusProfile\\data\\data.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        br.close();
        String[] temp1 = convertData(everything);
        List<String> temp2 = Arrays.asList(temp1);
        ArrayList<String> data = new ArrayList<>(temp2);
        getAnswer(data);
    }
}
