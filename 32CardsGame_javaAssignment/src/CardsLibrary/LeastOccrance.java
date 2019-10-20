package CardsLibrary;

import java.util.*;

class Cardss {
    int value;

    Cardss(int v) {
        this.value = v;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;

        if (object != null && object instanceof Cardss) {
            isEqual = (this.value == ((Cardss) object).value);
        }

        return isEqual;
    }

    @Override
    public int hashCode() {
        return this.value;
    }

}

class LeastOccrance {
    public static void main(String[] args) {

        ArrayList<Cardss> cards = new ArrayList();
        cards.add(new Cardss(3));
        cards.add(new Cardss(3));
        cards.add(new Cardss(1));
        cards.add(new Cardss(2));
        cards.add(new Cardss(1));
        Scanner s = new Scanner(System.in);
        HashMap<Cardss, Integer> hm = new HashMap();
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 0);
            }
        }
        Iterator it = hm.keySet().iterator();
        while (it.hasNext()) {
            System.out.print(((Cardss) it.next()).value);
        }
/*


        HashSet<Cardss> ht = new HashSet();
        for (int i = 0; i < cards.size(); i++) {

            if (ht.contains(cards.get(i))) {
                System.out.println(cards.get(i));
            } else {
                ht.add(cards.get(i));
            }
        }

*/
    }
}