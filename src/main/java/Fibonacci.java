/**
 *0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibonacciDP(3));
    }

    public static long fibonacci(int n) {
        if (n < 3) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static long fibonacciDP(int n) {
        long n1 = 1;
        long n2 = 1;
        long current = 1;
        for (int i = 3; i <= n; i++) {
            current = n1 + n2;
            n2 = n1;
            n1 = current;
        }
        return current;
    }
}
