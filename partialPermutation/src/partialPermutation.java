import java.math.BigInteger;

public class partialPermutation {

    public static void partialPermute(int n, int k) {
        BigInteger N = new BigInteger(Integer.toString(n));
        BigInteger K = new BigInteger(Integer.toString(k));
        BigInteger module = new BigInteger(Integer.toString(1000000));
        BigInteger result = factorial(N).divide(factorial(N.subtract(K)));
        BigInteger[] finalResult = result.divideAndRemainder(module);
        System.out.println(finalResult[1].intValue());
    }

    public static BigInteger factorial(BigInteger A) {
        BigInteger answer = new BigInteger("1");
        for (int i = 1; i <= A.intValue(); i++)
            answer = answer.multiply(new BigInteger(Integer.toString(i)));
        return answer;
    }

    public static void main(String[] args) {
        int n = 80;
        int k = 8;
        partialPermute(n, k);
    }
}
