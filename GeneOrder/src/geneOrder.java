public class geneOrder {

    public static int[] initial;

    public static void permute(int[] part, int left, int right) {
        if (left == right)
            print1dArray(part);
        else {
            for (int i = left; i <= right; i++) {
                part = swap(left, i, part);
                permute(part, left + 1, right);
                part = swap(left, i, part);
            }
        }
    }

    public static int[] swap(int A, int B, int[] list) {
        int[] output = new int[list.length];
        for (int i = 0; i < list.length; i++)
            output[i] = list[i];
        int valA = list[B];
        int valB = list[A];
        output[A] = valA;
        output[B] = valB;
        return output;
    }

    public static void print1dArray(int[] input) {
        String output = Integer.toString(input[0]);
        for (int i = 1; i < input.length; i++)
            output += " " + input[i];
        System.out.println(output);
    }

    public static int permutationCount(int k) {
        return factorial(k) / factorial(0);
    }

    public static int factorial(int k) {
        int answer = 1;
        if (k == 0 || k == 1)
            return 1;
        for (int i = 1; i <= k; i++)
            answer = answer * i;
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        initial = new int[n];
        for (int i = 0; i < n; i++)
            initial[i] = i + 1;
        System.out.println(permutationCount(n));
        permute(initial, 0, initial.length - 1);
    }
}
