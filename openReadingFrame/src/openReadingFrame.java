public class openReadingFrame {


    // RNA -> String[] RNA Pieces Method. <String> -> <String[]>
    public static String[] RNAbreakDown(String input) {
        int partitionCount = input.length() / 3;
        String[] output = new String[partitionCount];
        for (int i = 0; i < partitionCount; i++)
            output[i] = input.substring(3 * i, 3 * i + 3);
        return output;
    }

    // RNA -> Protein String Method. <String[]> -> <String>
    public static String RNA2Protein(String[] input) {
        String output = "";
        for (int i = 0; i < input.length; i++)
            output = output + proteinIdentifier(input[i]);
        return output;
    }

    // RNA Piece -> Protein Method. <String> -> <char>
    public static char proteinIdentifier(String input) {
        char output = '@';
        switch (input){
            case "AUG" : output = 'M'; break;
            case "UUU" : output = 'F'; break;
            case "UUC" : output = 'F'; break;
            case "UUA" : output = 'L'; break;
            case "UUG" : output = 'L'; break;
            case "CUU" : output = 'L'; break;
            case "CUC" : output = 'L'; break;
            case "CUA" : output = 'L'; break;
            case "CUG" : output = 'L'; break;
            case "AUU" : output = 'I'; break;
            case "AUC" : output = 'I'; break;
            case "AUA" : output = 'I'; break;
            case "GUU" : output = 'V'; break;
            case "GUC" : output = 'V'; break;
            case "GUA" : output = 'V'; break;
            case "GUG" : output = 'V'; break;
            case "UCU" : output = 'S'; break;
            case "UCC" : output = 'S'; break;
            case "UCA" : output = 'S'; break;
            case "UCG" : output = 'S'; break;
            case "AGU" : output = 'S'; break;
            case "AGC" : output = 'S'; break;
            case "CCU" : output = 'P'; break;
            case "CCC" : output = 'P'; break;
            case "CCA" : output = 'P'; break;
            case "CCG" : output = 'P'; break;
            case "ACU" : output = 'T'; break;
            case "ACC" : output = 'T'; break;
            case "ACA" : output = 'T'; break;
            case "ACG" : output = 'T'; break;
            case "GCU" : output = 'A'; break;
            case "GCC" : output = 'A'; break;
            case "GCA" : output = 'A'; break;
            case "GCG" : output = 'A'; break;
            case "UAU" : output = 'Y'; break;
            case "UAC" : output = 'Y'; break;
            case "CAU" : output = 'H'; break;
            case "CAC" : output = 'H'; break;
            case "CAA" : output = 'Q'; break;
            case "CAG" : output = 'Q'; break;
            case "AAU" : output = 'N'; break;
            case "AAC" : output = 'N'; break;
            case "AAA" : output = 'K'; break;
            case "AAG" : output = 'K'; break;
            case "GAU" : output = 'D'; break;
            case "GAC" : output = 'D'; break;
            case "GAA" : output = 'E'; break;
            case "GAG" : output = 'E'; break;
            case "UGU" : output = 'C'; break;
            case "UGC" : output = 'C'; break;
            case "UGG" : output = 'W'; break;
            case "CGU" : output = 'R'; break;
            case "CGC" : output = 'R'; break;
            case "CGA" : output = 'R'; break;
            case "CGG" : output = 'R'; break;
            case "AGA" : output = 'R'; break;
            case "AGG" : output = 'R'; break;
            case "GGU" : output = 'G'; break;
            case "GGC" : output = 'G'; break;
            case "GGA" : output = 'G'; break;
            case "GGG" : output = 'G'; break;
            case "UAA" : output = '#'; break;
            case "UAG" : output = '#'; break;
            case "UGA" : output = '#'; break;
        }
        return output;
    }

    // DNA -> RNA Method. <String> -> <String>
    public static String transcribeDNA(String input) {
        String answer = "";
        int inputLength = input.length();
        for (int i = 0; i < inputLength; i++) {
            if (input.charAt(i) == 'T')
                answer = answer + 'U';
            else
                answer = answer + input.charAt(i);
        }
        return answer;
    }

    public static String rna2str(String[] input) {
        String output = input[0];
        for (int i = 1; i < input.length; i++) {
            output = output + " " + input[i];
        }
        return output;
    }

    public static void main(String[] args) {

        String dna = "AGCCATGTAGCTAACTCAGGTTACATGGGGATGACCCCGCGACTTGGATTAGAGTCTCTTTTGGAATAAGCCTGAATGATCCGAGTAGCATCTCAG";
        String rna = transcribeDNA(dna);
        String[] rnaPiece = RNAbreakDown(rna);
        String protein = RNA2Protein(rnaPiece);
        System.out.println(protein);
        //System.out.println(rna);
        //System.out.println(rna2str(rnaPiece));
    }




}
