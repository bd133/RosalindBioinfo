import java.io.File;
import java.util.Scanner;

public class RNAtoProtein {
    public static String translate(String input) {
        int partitionCount = input.length() / 3;
        String temp, answer = "";
        for (int i = 0; i < partitionCount; i++) {
            temp = input.substring(i * 3, i * 3 + 3);
            if (temp.equals("AUG"))
                answer = answer + "M";
            else if (temp.equals("UUU") || temp.equals("UUC"))
                answer = answer + "F";
            else if (temp.equals("UUA") || temp.equals("UUG") || temp.equals("CUU") || temp.equals("CUC") || temp.equals("CUA") || temp.equals("CUG"))
                answer = answer + "L";
            else if (temp.equals("AUU") || temp.equals("AUC") || temp.equals("AUA"))
                answer = answer + "I";
            else if (temp.equals("GUU") || temp.equals("GUC") || temp.equals("GUA") || temp.equals("GUG"))
                answer = answer + "V";
            else if (temp.equals("UCU") || temp.equals("UCC") || temp.equals("UCA") || temp.equals("UCG") || temp.equals("AGU") || temp.equals("AGC"))
                answer = answer + "S";
            else if (temp.equals("CCU") || temp.equals("CCC") || temp.equals("CCA") || temp.equals("CCG"))
                answer = answer + "P";
            else if (temp.equals("ACU") || temp.equals("ACC") || temp.equals("ACA") || temp.equals("ACG"))
                answer = answer + "T";
            else if (temp.equals("GCU") || temp.equals("GCC") || temp.equals("GCA") || temp.equals("GCG"))
                answer = answer + "A";
            else if (temp.equals("UAU") || temp.equals("UAC"))
                answer = answer + "Y";
            else if (temp.equals("CAU") || temp.equals("CAC"))
                answer = answer + "H";
            else if (temp.equals("CAA") || temp.equals("CAG"))
                answer = answer + "Q";
            else if (temp.equals("AAU") || temp.equals("AAC"))
                answer = answer + "N";
            else if (temp.equals("AAA") || temp.equals("AAG"))
                answer = answer + "K";
            else if (temp.equals("GAU") || temp.equals("GAC"))
                answer = answer + "D";
            else if (temp.equals("GAA") || temp.equals("GAG"))
                answer = answer + "E";
            else if (temp.equals("UGU") || temp.equals("UGC"))
                answer = answer + "C";
            else if (temp.equals("CGU") || temp.equals("CGC") || temp.equals("CGA") || temp.equals("CGG") || temp.equals("AGA") || temp.equals("AGG"))
                answer = answer + "R";
            else if (temp.equals("UGG"))
                answer = answer + "W";
            else if (temp.equals("GGU") || temp.equals("GGC") || temp.equals("GGA") || temp.equals("GGG"))
                answer = answer + "G";
            else if (temp.equals("UAA") || temp.equals("UAG") || temp.equals("UGA")) {
                answer = answer + "";
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\RNAtoProtein\\data\\data.txt");
        Scanner sc = new Scanner(file);
        String data;
        String given = "";
        while (sc.hasNext()) {
            data = sc.next();
            given = given + data;
        }
        String result = translate(given);
        System.out.println(result);

        String testSequence = "AUGGUCUACAUAGCUGACAAACAGCACGUAGCAUCUCGAGAGGCAUAUGGUCACAUGUUCAAAGUUUGCGCCUAG";
        System.out.println(translate(testSequence));
    }
}
