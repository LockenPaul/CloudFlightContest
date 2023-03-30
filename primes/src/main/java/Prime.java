public class Prime {

    public long prime;
    private int count = 0;

    public Prime(long l) {
        this.prime = l;
        calc(prime);
    }

    public int getCount() {
        return count;
    }

    public void calc(long prime) {
        final String string = String.valueOf(prime);
        final int length = string.length();

        for (int i = 0; i < length; i++) {
            if(length == 1) {
                count++;
                continue;
            }
            char[] c = string.toCharArray().clone();
            c[i] = ' ';
            String[] split = String.valueOf(c).split(" ");
            StringBuilder sb = new StringBuilder(split[0]);
            if (split.length >= 2) sb.append(split[1]);
            long num = Long.parseLong(sb.toString());
            if(!isPrime(num)) {
                //count++;
                continue;
            }
            calc(num);
        }
    }

    public boolean isPrime(long num) {
        if (num <= 1)  return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
