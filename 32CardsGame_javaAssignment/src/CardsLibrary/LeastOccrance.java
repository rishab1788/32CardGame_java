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
        cards.add(new Cardss(4));
        cards.add(new Cardss(3));
        cards.add(new Cardss(1));
        cards.add(new Cardss(1));
        cards.add(new Cardss(4));
        Scanner s = new Scanner(System.in);
        HashMap<Cardss, Integer> hm = new HashMap();
        for (int i = 0; i < cards.size(); i++) {
            if (hm.containsKey(cards.get(i))) {
                hm.put(cards.get(i), hm.get(cards.get(i)) + 1);
            } else {
                hm.put(cards.get(i), 1);
            }
        }
        int minOccurance = 10;
        int minOccuranceValue = 0;
        for (Map.Entry<Cardss, Integer> entry : hm.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getValue() < minOccurance) {
                minOccurance = entry.getValue();
                minOccuranceValue = entry.getKey().value;
            }

        }
        System.out.println(minOccuranceValue);

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