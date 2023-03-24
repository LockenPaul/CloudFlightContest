public class Bidder {

    public String name;
    public int max;

    public Bidder(String name, int max) {
        this.name = name;
        this.max = max;
    }

    @Override
    public String toString() {
        return "WINNER: '" + name + "," + max + "'";
    }
}
