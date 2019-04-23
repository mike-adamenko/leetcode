/**
 *0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55
 */
public class Fibonacci {
    public static void main(String[] args) {
        fibonacci(20);
    }

//    public static long fibonacci(int n) {
//        if (n < 3) return 1;
//        return fibonacci(n-1) + fibonacci(n-2);
//    }

    public static void fibonacci(int n) {
        long n1 = 1;
        long n2 = 1;
        long current = 1;
        for (int i = 3; i <= n; i++) {
            System.out.print(current+" ");
            current = n1 + n2;
            n2 = n1;
            n1 = current;
        }
    }
}
