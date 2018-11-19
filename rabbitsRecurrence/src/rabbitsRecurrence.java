import java.io.File;
import java.util.Scanner;

public class rabbitsRecurrence {
    public static long iteration(int months, int pairs) {
        int errorCount = 0;
        if (months == 1)
            return 1;
        else if (months == 2)
            return pairs;
        else
            errorCount += 1;
        long f_1 = iteration(months - 1, pairs), f_2 = iteration(months - 2, pairs);
        if (months <= 4)
            return (f_1 + f_2);
        return (f_1 + (f_2 * pairs));
    }

    public static long recurrence(String input) {
        String[] parts = input.split(" ");
        long answer;
        int n = Integer.parseInt(parts[0]), k = Integer.parseInt(parts[1]);
        answer = iteration(n, k);
        return answer;
    }

    public static void main(String[] args) throws Exception {
        int inputN = 30, inputK = 4;
        String given = inputN + " " + inputK;
        long result = recurrence(given);
        System.out.println(result);
    }
}