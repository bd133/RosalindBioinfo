public class AH_FIBO {

    public static int fib(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int data = 21;
        System.out.println(fib(data));
    }
}
