import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class AuctionBidding {

    public static void main(String[] args) {
        System.out.println(calculatePrice(1, toBidders(
                "1,A,5,B,10,A,8,A,14,A,17,B,17"
        ).toArray(Bidder[]::new)));
        System.out.println(calculatePrice(1, toBidders(
                "100,A,100,A,115,A,119,A,144,A,145,A,157,A,158,A,171,A,179,A,194,A,206,A,207,A,227,A,229,A,231,A,234"
        ).toArray(Bidder[]::new)));
        System.out.println(calculatePrice(15, toBidders(
                "100,C,100,C,115,C,119,C,121,C,144,C,154,C,157,G,158,C,171,C,179,C,194,C,206,C,214,C,227,C,229,C,231,C,298"
        ).toArray(Bidder[]::new)));
        System.out.println(calculatePrice(100, toBidders(
                "1,nepper,15,hamster,24,philipp,30,mmautne,31,hamster,49,hamster,55,thebenil,57,fliegimandi,59,ev,61,philipp,64,philipp,65,ev,74,philipp,69,philipp,71,fliegimandi,78,hamster,78,mio,95,hamster,103,macquereauxpl,135"
        ).toArray(Bidder[]::new)));
        System.out.println(calculatePrice(100, toBidders(
                "15,urtyp,15"
        ).toArray(Bidder[]::new)));
        System.out.println(calculatePrice(100, toBidders(
                "1,rx,50,aa,2000,de,3558,einseins,3999,ek,4999,yd,8332,lb,5000,lb,6000,lb,7000,lb,8000,lb,8999,yd,9999,zn,11000,ir,11110,nr,12999,kt,12567,kt,12667,kt,13000,go,14000,ym,14999,hm,15400,nr,15690,nr,17000,td,18500,kt,18750,uy,18850,hr,18999,td,19049,st,19200"
        ).toArray(Bidder[]::new)));
    }

    private static Bidder calculatePrice(int start, Bidder[] bidders) {
        Bidder highest = bidders[0];
        boolean shouldPrint;
        StringBuilder history = new StringBuilder("-,");
        history.append(start).append(",").append(highest.name).append(",").append(start).append(",");
        for (int i = 1; i < bidders.length; i++) {
            Bidder pos = bidders[i];
            shouldPrint = !Objects.equals(highest.name, pos.name);
            if (shouldPrint) history.append(pos.name).append(",");
            if (pos.max > start && !Objects.equals(highest.name, pos.name)) start = pos.max;
            if (pos.max == highest.max) {
                if (shouldPrint) history.append(start).append(",");
                continue;
            }
            if (!(highest.name.equals(pos.name)))
                start = pos.max > highest.max ? highest.max + 1 : pos.max + 1;
            if (pos.max > highest.max) highest = pos;
            if (shouldPrint) history.append(start).append(",");
        }
        System.out.println(history.deleteCharAt(history.length() - 1));
        return new Bidder(highest.name, start);
    }

    private static List<Bidder> toBidders(String input) {
        List<Bidder> bidders = new ArrayList<>();

        String[] str = input.trim().split(",");
        for (int i = 1; i < str.length; i += 2) {
            bidders.add(new Bidder(str[i], Integer.parseInt(str[i + 1])));
        }

        return bidders;
    }
}
