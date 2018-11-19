import java.util.ArrayList;

public class kmerLex {

    public static ArrayList<String> lex(char[] data, int n) {
        ArrayList<String> output = new ArrayList<>();
        permute(data, n, "", output);
        return output;
    }

    public static void permute(char[] data, int length, String prefix, ArrayList<String> list) {
        if (length == 0) {
            list.add(prefix);
            return;
        }
        for (int i = 0; i < data.length; i++)
            permute(data, length - 1, prefix + data[i], list);
    }

    public static void main(String[] args) {
        char[] data = new char[]{'A', 'B', 'C', 'D'};
        int n = 4;
        ArrayList<String> result = lex(data, n);
        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));
    }
}
