import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

class Card {
    int value;

    Card(int v) {
        this.value = v;
    }
}

public class LeastOccrance {
    public static void main(String[] args) {
        ArrayList<Card> cards = new ArrayList();
        cards.add(new Card(3));
        cards.add(new Card(3));
        cards.add(new Card(1));
        cards.add(new Card(2));
        cards.add(new Card(1));
        Scanner s = new Scanner(System.in);
        HashMap<Card, Integer> hm = new HashMap();
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 0);
            }
        }
        Iterator it = hm.keySet().iterator();
        while (it.hasNext()) {
            System.out.print(((Card) it.next()).value);
        }
    }
}
