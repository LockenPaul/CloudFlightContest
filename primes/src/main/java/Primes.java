import java.util.Arrays;

public class Primes {

    public static void main(String[] args) {
        long[] input = {
            4125673, 41256793, 337424981, 537430451, 200899998, 537499093, 2147483059, 410256793, 567629137, 46216567629137L
        };
        long i = Long.MAX_VALUE;
        Arrays.stream(input).mapToObj(Prime::new)
                .forEach(prime -> {
                    System.out.println("Prime: " + prime.prime + " | res: " + prime.getCount());
                });
    }
}
