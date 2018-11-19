import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Hashtable;

public class RNASplicing {

    public static Hashtable<String, Character> codonTable = new Hashtable<>();
    public static String target_DNA;
    public static String target_RNA;
    public static String target_Protein;
    public static ArrayList<String> DNATable = new ArrayList<>();
    public static ArrayList<String> RNATable = new ArrayList<>();
    public static ArrayList<String> ProteinTable = new ArrayList<>();
    public static String result;

    public static void splice() {
        String output = target_Protein;
        for (int i = 0; i < ProteinTable.size(); i++)
            output = output.replace(ProteinTable.get(i), "");
        result = output;
        System.out.println(result);
    }

    public static void toProtein() {
        target_Protein = RNAtoProtein(target_RNA);
        for (int i = 0; i < RNATable.size(); i++)
            ProteinTable.add(i, RNAtoProtein(RNATable.get(i)));
    }

    public static String RNAtoProtein(String input) {
        String output = "";
        for (int i = 0; i < input.length() - 3; i+= 3) {
            String codon = input.substring(i, i + 3);
            char next = codonTable.get(codon);
            if (next == '\0')
                break;
            output += next;
        }
        return output;
    }

    public static void toRNA() {
        target_RNA = DNAtoRNA(target_DNA);
        for (int i = 0; i < DNATable.size(); i++)
            RNATable.add(i, DNAtoRNA(DNATable.get(i)));
    }

    public static String DNAtoRNA(String input) {
        String answer = "";
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'T')
                answer = answer + 'U';
            else
                answer = answer + input.charAt(i);
        }
        return answer;
    }

    public static void craftData(String input) {
        String newInput = input.replaceAll("\\s", ",");
        newInput = newInput.replaceAll(",,", "");
        newInput = newInput.replaceAll(">Rosalind_", ",");
        newInput = newInput.substring(1);
        newInput = newInput.replaceAll("[0-9]", "4");
        newInput = newInput.replaceAll("4", "");
        String[] temp1 = newInput.split(",");
        target_DNA = temp1[0];
        for (int i = 1; i < temp1.length; i++)
            DNATable.add(i - 1, temp1[i]);
    }

    public static void initCodonTable() {
        codonTable.put("UUU",'F');
        codonTable.put("CUU",'L');
        codonTable.put("AUU",'I');
        codonTable.put("GUU",'V');
        codonTable.put("UUC",'F');
        codonTable.put("CUC",'L');
        codonTable.put("AUC",'I');
        codonTable.put("GUC",'V');
        codonTable.put("UUA",'L');
        codonTable.put("CUA",'L');
        codonTable.put("AUA",'I');
        codonTable.put("GUA",'V');
        codonTable.put("UUG",'L');
        codonTable.put("CUG",'L');
        codonTable.put("AUG",'M');
        codonTable.put("GUG",'V');
        codonTable.put("UCU",'S');
        codonTable.put("CCU",'P');
        codonTable.put("ACU",'T');
        codonTable.put("GCU",'A');
        codonTable.put("UCC",'S');
        codonTable.put("CCC",'P');
        codonTable.put("ACC",'T');
        codonTable.put("GCC",'A');
        codonTable.put("UCA",'S');
        codonTable.put("CCA",'P');
        codonTable.put("ACA",'T');
        codonTable.put("GCA",'A');
        codonTable.put("UCG",'S');
        codonTable.put("CCG",'P');
        codonTable.put("ACG",'T');
        codonTable.put("GCG",'A');
        codonTable.put("UAU",'Y');
        codonTable.put("CAU",'H');
        codonTable.put("AAU",'N');
        codonTable.put("GAU",'D');
        codonTable.put("UAC",'Y');
        codonTable.put("CAC",'H');
        codonTable.put("AAC",'N');
        codonTable.put("GAC",'D');
        codonTable.put("CAA",'Q');
        codonTable.put("AAA",'K');
        codonTable.put("GAA",'E');
        codonTable.put("CAG",'Q');
        codonTable.put("AAG",'K');
        codonTable.put("GAG",'E');
        codonTable.put("UGU",'C');
        codonTable.put("CGU",'R');
        codonTable.put("AGU",'S');
        codonTable.put("GGU",'G');
        codonTable.put("UGC",'C');
        codonTable.put("CGC",'R');
        codonTable.put("AGC",'S');
        codonTable.put("GGC",'G');
        codonTable.put("CGA",'R');
        codonTable.put("AGA",'R');
        codonTable.put("GGA",'G');
        codonTable.put("UGG",'W');
        codonTable.put("CGG",'R');
        codonTable.put("AGG",'R');
        codonTable.put("GGG",'G');
        codonTable.put("UAA",'\0');
        codonTable.put("UAG",'\0');
        codonTable.put("UGA",'\0');
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\xwbd1\\IdeaProjects\\RosalindBioinfo\\RNASplicing\\data\\data.txt"));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        while (line != null) {
            sb.append(line);
            sb.append(System.lineSeparator());
            line = br.readLine();
        }
        String everything = sb.toString();
        br.close();
        initCodonTable();
        craftData(everything);
        toRNA();
        toProtein();
        splice();
    }
}
