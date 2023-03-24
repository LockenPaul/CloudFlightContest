import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        Integer[] input = { 6, 19, 28, 36, 38 };
        Arrays.stream(input)
                .map(Fibonacci::fib)
                .forEach(System.out::println);
    }

    private static int fib(int n) {
        if(n <= 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
