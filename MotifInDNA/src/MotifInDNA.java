import java.util.ArrayList;

public class MotifInDNA {
    public static String position(String sequence, String piece) {
        int sequenceL = sequence.length(), pieceL = piece.length(), k = 0;
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < sequenceL - pieceL; i++) {
            String temp = sequence.substring(i, i + pieceL);
            if (temp.equals(piece)) {
                resultArr.add(k, i + 1);
                k += 1;
            }
        }
        String output = Integer.toString(resultArr.get(0));
        for (int j = 1; j < resultArr.size(); j++)
            output = output + " " + resultArr.get(j);
        return output;
    }

    public static String delete(String sequence, String piece) {
        int pieceL = piece.length(), position = Integer.parseInt(position(sequence, piece));
        System.out.println(sequence.substring(position - 1, position + pieceL - 1));
        return sequence.replace(sequence.substring(position - 1, position + pieceL - 1), "");
    }

    public static void main(String[] args) {
        String dnaSequence = "ATGGTCTACATAGCTGACAAACAGCACGTAGCAATCGGTCGAATCTCGAGAGGCATATGGTCACATGATCGGTCGAGCGTGTTTCAAAGTTTGCGCCTAG";
        String motifPiece = "ATCGGTCGAGCGTGT";
        String answer = position(dnaSequence, motifPiece);
        System.out.println(answer);

        String piece2 = "ATCGGTCGAA";
        System.out.println(delete(delete(dnaSequence, piece2), motifPiece));
    }
}
